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
> > dimana terdapat method untuk membuat Validator menggunakan FactoryBean => LocalValidatorFactoryBean.

> > > Contoh: Membuat Validation Auto Configuration
>> 1. Membuat pacakage data -> class Person
>> 2. Membuat unit test untuk Person -> Class ValidatorTest

## Custom Constraint - Membuat Annotation & validasinya sendiri

```
- Keutungan: jika menggunakan validator yang dibuat otomatis oleh Spring 
  adalah bisa membuat Custom Constraints, ynag otomatis dijadikan bean oleh Spring.
- Dengan begitu, kita dapat menambahkan dependency injection terhadap bean Custom Constraint tersebut.
```

> Contoh: Membuat Custom Constraint, dgn membuat sebuah bean namanya StringHelper, dengan @Component.
> > 1. Buat pacakage helper -> class StringHelper
> > 2. Buat palindrme annotation -> Buat sebuah annotation @Palindrome
       > > Pada package validation -> new file tipe annotation -> namanya Palindrome
> > 3. Buat class PalindromeValidator di package validation, yang digunakan untuk melakukan validasi.
> > 4. Buat kelas Foo => pacakage data.
> > 5. Buat unit test baru, namanmya PalindromeTest.
> > 6. Buat test untuk invalid palindrome dan valid palindrome.

## Message Source

```
- Saat membuat error message di Bean Validation, secara otomatis Bean
  Validation akan mencari pesan error di file messages.properties.
- Secara defaault, Messsage Source akan mencari pesan error di file messages.properties.
```

> > Contoh: Membuat messages.properties
> > 1. Buat file messages.properties di src/main/resources.
> > 2. Update unit testnya pada class ValidatorTest => palindromeInvalidMessage()

## Method Validation

```
- Menggunakan Bean validation pada method untuk melakukan validation di level method sangat ribet.
- Namun ini dibantu dengan fitur Bean Post Processor.
- Spring menggunakan class MethodValidationPostProcessor akan otomatis mencari bean yang memiliki annotation @Validated.
- Kita tidak perlu meregistrasikan MethodValidationPostProcessor secara manual,
  itu sudah otomatis dibuat oleh class ValidationAutoConfiguration.
- Jika terjadi validasi error, secara otomatis akan throw ConstraintViolationException.
```

> > Contoh: Membuat Method Validation
> >> 1. Membuat sebuah component Sayhello
        dengan setiap method memiliki fitur validasi secara otomatis.
        Pada pacakage helper => SayHello.java
> >> 2. Buat class SayHelloTest untuk melakukan unit test.

## Method Overriding

```
- Hal yang sering dilakukan oleh programmer Spring adalah membuat kontrak berupa interface, 
  dan membuat bean berupa class implementasi dari interface tersebut.
- Hati-hati kalau menggunakan interface sebagai kontrak-nya,
  karena ketika kita override methodnya di class,
  lalu di dalam method tersebut kita tambahkan annotation untuk Bean Validation, 
  maka ototmatis akan terjadi error.
- Karena Bean validation mendeteksi terjadi perubahan di method overridingnya. 
  (Misalnya di dalam interface tidak ada anotation @BeanValidation,
  tapi di dalam class implemetasinya ada anotation @BeanValidation).
```

> > Contoh: Method Overriding
> >> 1. Buat di pacakage helper -> interface ISayHello
> >> 2. Ubah class SayHello menjadi implementasi dari ISayHello.
> >> 3. Kemudian coba jalankan say hello test.

> Solusinya gimana?
> > Memindahkan semua anotation Validation ke dalam interface-nya.
> > Dengan demikian, bean validation tidak akan mendeteksi adanya perubahan ada method overriding-nya.   