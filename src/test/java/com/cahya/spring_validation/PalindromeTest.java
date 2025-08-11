package com.cahya.spring_validation;

import com.cahya.spring_validation.data.Foo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;


@SpringBootTest
public class PalindromeTest {

    @Autowired
    private Validator validator;

    @Test
    void palindromeValid() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("kodok"));
        Assertions.assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void palindromeInvalid() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("cahya"));
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(1, constraintViolations.size());
    }
}
