package com.cahya.spring_validation.data;

import com.cahya.spring_validation.validation.Palindrome;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo {

    @Palindrome
    private String bar;
}
