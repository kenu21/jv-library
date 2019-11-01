package com.kenu.spring.annotations;

import com.kenu.spring.dto.UserRegistrationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserRegistrationDto user = (UserRegistrationDto) obj;
        return user.getPassword().equals(user.getRepeatPassword());
    }
}
