# Spring Validation

### url
https://docs.google.com/presentation/d/133iTYTxD52P5vD-Z74Gt4_I8A5ESZbzOsKcP4REize4/edit?slide=id.p#slide=id.p

### Intro
```
- Spring Validation memiliki vitur validation, sehingga tidak perlu membuat kode Validation secara manual.
- Keuntungan, format validation menjadi standard untuk semua programmer.
- Untuk standar akan menggunakan BEAN Validation.
```

## Bean Validation
```
- Keuntungan: bisa menggunakan bean yang sudah ada.
- Object validator dibuat secara otomatis oleh Spring.
- Yang terpenting, kita bisa membuat Custom Validator, 
  memanfaatkan Dependenct Injection di Spring pada Custon Validator.
```
> Q: Bagaimana Spring membuat bean Validator?
>> A: Spring membuat bean Validator menggunakan class ValidationAutoConfiguration.
>>   dimana terdapat method untuk membuat Validator menggunakan FactoryBean => LocalValidatorFactoryBean.

>>> Contoh: Membuat Validation Auto Configuration
>> 1. Membuat pacakage data -> class Person
>> 2. Membuat unit test untuk Person -> Class ValidatorTest