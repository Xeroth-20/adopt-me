package dev.jx.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import dev.jx.app.entity.Pet;

@Component
public class PetValidator implements Validator {

    @Override
    public boolean supports(Class<?> oClass) {
        return Pet.class.equals(oClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "image.id", "NotNull.image.id", "This field is required");
        ValidationUtils.rejectIfEmpty(errors, "animal.id", "NotNull.animal.id", "This field is required");
    }
}
