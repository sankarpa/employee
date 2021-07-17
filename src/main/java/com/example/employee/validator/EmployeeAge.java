package com.example.employee.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(
        validatedBy = {EmployeeAgeValidator.class}
)
@Target({FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface EmployeeAge {

    String message() default "Employee should be older than 18 years";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
