package challenge;

import Class.Card;
import Class.ExpirationDate;
import Class.Sale;
import Class.Card.Brand;

public class Main {

	public static void main(String[] args) {
		ExpirationDate expirationDate = new ExpirationDate(05,27);
		ExpirationDate expirationDate2 = new ExpirationDate(05,21);
		
		Card card = new Card(Brand.VISA,1234567l,"juan villalba",expirationDate);
		Card card2 = new Card(Brand.NARA,12398767l,"nestor villalba",expirationDate2);
		System.out.println("----- Mostrando datos de una tarjeta -----");
		Card.showCard(card);
		
		System.out.println("----- Informando si dos tarjetas son iguales -----");
		Card.compareCard(card, card);
		
		System.out.println("----- Creando una operacion valida -----");
		try {
			Sale sale = new Sale(1000f,card);
		}catch (Exception  e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("----- realizando una operacion no valida -----");
		try {
			Sale sale = new Sale(10000f,card2);
		}catch (Exception  e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("----- Simulando una venta y obteniedno la tasa, marca de la tarjeta y precio final -----");
		try {
			Sale.simulateSale(500f, card);
		}catch (Exception  e) {
			System.out.println(e.getMessage());
		}
		
	}

}
