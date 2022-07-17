package com.challenge.JavaChallenge.models.card;

import lombok.Getter;
import lombok.Setter;

public class Card {
    public enum  Brand{
        VISA,
        NARA,
        AMEX
    }
    @Getter @Setter
    private Brand brand;
    @Getter @Setter
    private Long cardNumber;
    @Getter @Setter
    private String cardholder;
    @Getter @Setter
    private ExpirationDate expirationDate;


    public static boolean validateCard(Card card){
        if (card.getCardNumber() < 100000000000000l) {
            return false;
        } else if (card.getExpirationDate() == null) {
            return false;
        } else if (card.getBrand() == null) {
            return false;
        } else if (card.getCardholder().isEmpty() || card.getCardholder() == null) {
            return false;
        }
        return true;
    }

    public static boolean compareCard(Card card1, Card card2){
        return card1.equals(card2);
    }
}
