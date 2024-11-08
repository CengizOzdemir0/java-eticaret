package com.cengiz.javaeticaret.helper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

public class AlphabeticValidator implements ConstraintValidator<Alphabetic, String> {

    @Override
    public void initialize(Alphabetic constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ]+");
    }
}
