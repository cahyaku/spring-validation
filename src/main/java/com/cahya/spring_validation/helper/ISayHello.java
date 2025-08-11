package com.cahya.spring_validation.helper;

import jakarta.validation.constraints.NotBlank;

//@Validated
public interface ISayHello {
    String sayHello(@NotBlank(message = "Name is required") String name);
}
