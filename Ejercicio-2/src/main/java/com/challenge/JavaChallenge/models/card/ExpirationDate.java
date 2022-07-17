package com.challenge.JavaChallenge.models.card;

import lombok.Getter;
import lombok.Setter;

public class ExpirationDate {
    @Getter @Setter
    private Integer month;
    @Getter @Setter
    private Integer year;


    public ExpirationDate(Integer month, Integer year) {
        if (month < 1 || month > 12)
            throw new ArithmeticException("El mes no puede ser menor a 1 ni mayor a 12");
        if (year < 1 || year > 99)
            throw new ArithmeticException("El año no puede ser menor a 1 ni mayor a 99");
        this.month = month;
        this.year = year;
    }
}
