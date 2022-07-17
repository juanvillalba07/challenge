package com.challenge.JavaChallenge.models.sale;

import com.challenge.JavaChallenge.models.card.Card;
import com.challenge.JavaChallenge.models.sale.SaleResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimulateResponse {
    @Getter @Setter
    private Card.Brand brand;
    @Getter @Setter
    private Float rate;
    @Getter @Setter
    private Float finalPrice;

    public SimulateResponse(Card card, Float amount) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        String dateNow = dtf.format(LocalDateTime.now());
        if(!SaleRequest.validateCard(dateNow, card))
            throw new Exception("Tarjeta no valida para operar");
        if(amount > 1000)
            throw new Exception("El monto maximo para operar es de 1000");
        this.brand = card.getBrand();
        this.rate = SaleResponse.calculateRate(dateNow,card);
        this.finalPrice = SaleResponse.calculateFinalPrice(rate,amount);
    }
}
