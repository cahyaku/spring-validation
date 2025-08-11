package com.cahya.spring_validation;

import com.cahya.spring_validation.helper.SayHello;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SayHelloTest {
    @Autowired
    private SayHello sayHello;

    @Test
    void testSuccess() {
        String result = sayHello.sayHello("Cahya");
        Assertions.assertEquals("Hello Cahya", result);
    }

    @Test
    void testError() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            sayHello.sayHello("");
        });
    }
}

