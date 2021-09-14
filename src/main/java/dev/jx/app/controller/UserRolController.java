package dev.jx.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import dev.jx.app.entity.User;
import dev.jx.app.entity.Role;
import dev.jx.app.service.UserService;
import dev.jx.app.service.RoleService;

@Controller
public class UserRolController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;

    @RequestMapping(value = "/users-roles/register", method = RequestMethod.POST)
    public String postRegister(@RequestParam Integer userId, @RequestParam Integer roleId) {
        User user = this.userService.findById(userId);
        Role role = this.roleService.findById(roleId);
        user.getRoles().add(role);
        this.userService.update(user);

        return "redirect:/users/" + user.getId() + "/roles";
    }

    @RequestMapping(value = "/users-roles/delete", method = RequestMethod.POST)
    public String postDelete(@RequestParam Integer userId, @RequestParam Integer roleId) {
        User user = this.userService.findById(userId);
        Role role = this.roleService.findById(roleId);
        user.getRoles().remove(role);
        this.userService.update(user);

        return "redirect:/users/" + user.getId() + "/roles";
    }
}
