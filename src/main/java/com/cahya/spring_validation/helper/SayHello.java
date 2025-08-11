package com.cahya.spring_validation.helper;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Contoh menggaunakan @Validated pada class.
 */
@Validated
@Component
public class SayHello {
    /**
     * Sebelumnya wajib buat sbg berikut: Tapi dengan @Validated pada class ini, tidak perlu lagi.
     * @Autowired
     * private ValidationService validator;
     */

    /**
     * Jadi cukup gunakan annotation, misalnya @Valid, @NotBlank, @NotEmpty, @Size, dll
     *
     * @NotBlank message-nya wajib diisi jika tidak,
     * akan muncul error ketika menggunakan throw new ConstraintViolationException
     */
    public String sayHello(@NotBlank(message = "Name is required") String name) {
        return "Hello " + name;
    }
}
