package com.example.employeesmanagement.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    @NotEmpty(message = "id should not be empty")
    @Size(min = 2,message = "the id should be more than 2")
    private String id;
    @NotEmpty(message = "name should not be empty")
    @Size(min=4,message = "the name should be more than 4")
    private String name;
    @NotNull(message = "you should enter numbers ")
    @Positive
    @Min(25)
    private int age;
    @NotEmpty(message = "position should not be empty")
    @Pattern(regexp ="supervisor|coordinator", message = "The value must be either supervisor or coordinator")

    private String position;
    @AssertFalse
    private boolean onLeave;
    @NotNull(message = "employment year should not be empty")
    @Positive
    @Min(1990)
    @Max(2023)

    private int employmentYear;
    @NotNull(message ="annual Leave should not be empty" )
    @PositiveOrZero
    private int annualLeave;
}
