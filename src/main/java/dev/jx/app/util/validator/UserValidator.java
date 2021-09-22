package dev.jx.app.util.validator;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import dev.jx.app.entity.User;
import dev.jx.app.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Override
    public boolean supports(Class<?> oClass) {
        return User.class.equals(oClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (this.userService.existsByUsername(user.getUsername())) {
            errors.rejectValue("username", "UsernameExists.username", "Username already exists");
        }
    }

    public void validateNewPassword(Object o, String passwordToCompare, Errors errors) {
        User user = (User) o;
        if (!user.getPassword().equals(passwordToCompare)) {
            errors.rejectValue(
                    "password",
                    "PasswordMatch.password",
                    "Password does not match confirm password"
            );
        }
    }
}
