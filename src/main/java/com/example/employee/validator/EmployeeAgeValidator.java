package com.example.employee.validator;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class EmployeeAgeValidator implements ConstraintValidator<EmployeeAge, Date> {


    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {

        if(value != null){
            Integer age = Period.between(LocalDate.ofInstant(value.toInstant(), ZoneId.systemDefault()),
                    LocalDate.now()).getYears();

            if(age > 18){
                return true;
            }
        }

        return false;
    }
}
