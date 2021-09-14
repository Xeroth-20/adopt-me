package dev.jx.app.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;

import dev.jx.app.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.security.crypto.password.PasswordEncoder;
import dev.jx.app.entity.User;
import dev.jx.app.service.UserService;
import dev.jx.app.service.RoleService;
import dev.jx.app.dto.UserDTO;
import dev.jx.app.validation.UserValidator;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getIndex(Model model, Map<String, Object> map) {
        map.put("users", this.userService.findAll().stream().map(UserDTO::new).collect(Collectors.toList()));
        return "/users/index";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.GET)
    public String getRegister(Model model, Map<String, Object> map) {
        model.addAttribute("user", new User());
        return "/users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String postRegister(
            @RequestParam String confirmPassword,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        String page = "redirect:/users";
        this.userValidator.validate(user, bindingResult);
        this.userValidator.validateNewPassword(user, confirmPassword, bindingResult);

        if (bindingResult.hasErrors()) {
            page = "/users/register";
            model.addAttribute("user", user);
        } else {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            this.userService.insert(user);
        }

        return page;
    }

    @RequestMapping(value = "/users/{id}/change-password", method = RequestMethod.GET)
    public String getChangePassword(@PathVariable Integer id, Model model) {
        User user = this.userService.findById(id);
        user.setPassword(null);
        model.addAttribute("user", user);

        return "/users/change-password";
    }

    @RequestMapping(value = "/users/{id}/roles", method = RequestMethod.GET)
    public String getRoles(@PathVariable Integer id, Model model, Map<String, Object> map) {
        User user = this.userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("role", new Role());
        map.put("roles", this.roleService.findAllByUsersNotContains(user));

        return "/users/roles";
    }

    @RequestMapping(value = "/users/{id}/change-password", method = RequestMethod.POST)
    public String postChangePassword(
            @RequestParam String confirmPassword,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        String page = "redirect:/users";
        this.userValidator.validateNewPassword(user, confirmPassword, bindingResult);

        if (bindingResult.hasErrors()) {
            page = "/users/change-password";
            model.addAttribute("user", user);
        } else {
            user.setRoles(new HashSet<>(this.roleService.findAllByUsersContains(user)));
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            this.userService.update(user);
        }

        return page;
    }

    @RequestMapping(value = "/users/{id}/enable", method = RequestMethod.GET)
    public String getEnableAccount(@PathVariable Integer id) {
        User user = this.userService.findById(id);
        user.setActive(true);
        this.userService.update(user);

        return "redirect:/users";
    }


    @RequestMapping(value = "/users/{id}/disable", method = RequestMethod.GET)
    public String getDisableAccount(@PathVariable Integer id) {
        User user = this.userService.findById(id);
        user.setActive(false);
        this.userService.update(user);

        return "redirect:/users";
    }
}
