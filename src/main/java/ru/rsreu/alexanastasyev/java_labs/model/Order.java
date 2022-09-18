package ru.rsreu.alexanastasyev.java_labs.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {
    @NotBlank(message = "Pick one course")
    private String course;

    @NotBlank(message = "Name is required")
    private String userName;

    @CreditCardNumber(message="Not a valid credit card number")
    private String creditCardNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
    private String creditCardExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String creditCardCVV;
}
