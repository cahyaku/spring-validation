package com.cahya.spring_validation;

import com.cahya.spring_validation.data.Person;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.validation.Validator;
import java.util.Set;

@SpringBootTest
public class ValidatorTest {

    /**
     * Object validator, tidak perlu buat manual.
     * Langsung import dari spring.
     */
    @Autowired
    private Validator validator;

    @Test
    void personNotValid(){
        // test yang tidak valid
        var person = new Person("", "");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(2, constraintViolations.size());
    }

    @Test
    void personValid(){
        // test yang valid
        var person = new Person("1", "Cahya");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertTrue(constraintViolations.isEmpty());
    }
}
