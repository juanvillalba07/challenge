package com.challenge.JavaChallenge.models.sale;

import com.challenge.JavaChallenge.models.card.Card;
import com.challenge.JavaChallenge.models.sale.SaleRequest;
import lombok.Getter;
import lombok.Setter;

public class SaleResponse extends SaleRequest {
    @Getter @Setter
    private Float rate;
    @Getter @Setter
    private String saleDate;
    @Getter @Setter
    private Float finalPrice;


    public static Float calculateRate(String date, Card card) {
        String[] saleDate = date.split("/");
        Integer saleDay = Integer.parseInt(saleDate[0]);
        Integer saleMonth = Integer.parseInt(saleDate[1]);
        Integer saleYear = Integer.parseInt(saleDate[2]);
        Float rate = 0f;

        if(card.getBrand()==Card.Brand.VISA)
            rate = saleYear.floatValue()/saleMonth.floatValue();
        if(card.getBrand()==Card.Brand.NARA)
            rate = saleDay.floatValue()*0.5f;
        if(card.getBrand()==Card.Brand.AMEX)
            rate = saleMonth.floatValue()*0.1f;

        return rate;
    }


    public static Float calculateFinalPrice(Float rate, Float amount) {
        Float finalPrice = 0f;

        finalPrice = amount+amount*rate/100f;

        return finalPrice;
    }
}
