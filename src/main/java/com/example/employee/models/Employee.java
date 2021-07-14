package com.example.employee.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.util.concurrent.atomic.AtomicInteger;

@KeySpace("employees")
@Getter
@Setter
public class Employee {
    private static final AtomicInteger count = new AtomicInteger(1);

    @Id
    private Integer id = count.addAndGet(1);
    private String name;
}
