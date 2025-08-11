package com.cahya.spring_validation.validation;

import com.cahya.spring_validation.helper.StringHelper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Claas ini yangh melakukan validasinya
 */
public class PalindromeValidator implements ConstraintValidator<Palindrome, String> {

    @Autowired
    private StringHelper stringHelper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return stringHelper.isPalindrome(value);
    }
}
