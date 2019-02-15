package loadservices;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Adress:URL
@Retention(RetentionPolicy.RUNTIME)
public @interface Adress {
    String value() default "/";
}
