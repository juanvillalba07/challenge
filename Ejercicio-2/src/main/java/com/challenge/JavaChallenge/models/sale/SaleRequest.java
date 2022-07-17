package com.challenge.JavaChallenge.models.sale;

import com.challenge.JavaChallenge.models.card.ExpirationDate;
import com.challenge.JavaChallenge.models.card.Card;
import lombok.Getter;
import lombok.Setter;

public class SaleRequest {
    @Getter @Setter
    private Card card;
    @Getter @Setter
    private Float amount;


    public static boolean validateSale(SaleRequest saleRequest, ExpirationDate fechaActual){
        if(saleRequest.getAmount() > 1000 || saleRequest.getAmount() < 1)
            return false;
        if(!Card.validateCard(saleRequest.getCard()))
            return false;
        if(fechaActual.getMonth() > saleRequest.getCard().getExpirationDate().getMonth()
                && fechaActual.getYear() > saleRequest.getCard().getExpirationDate().getYear())
            return false;
        return true;
    }

    public static boolean validateCard(String date, Card card) {
        String[] saleDate = date.split("/");
        Integer saleMonth = Integer.parseInt(saleDate[1]);
        Integer saleYear = Integer.parseInt(saleDate[2]);
        Integer cardMonth = card.getExpirationDate().getMonth();
        Integer cardYear = card.getExpirationDate().getYear();

        if(cardYear < saleYear){
            return false;
        }else if (cardMonth < saleMonth){
            return false;
        }
        return true;
    }
}
