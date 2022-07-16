package Class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Class.Card.Brand;

public class Sale {
	private Float amount;
	private Card card;
	private Float rate;
	private Float finalPrice;
	private String date;
	
	
	
	public Sale(Float amount, Card card) throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        this.date = dtf.format(LocalDateTime.now());
        if(!validateCard(this.date, card)) 
        	throw new Exception("Tarjeta no valida para operar");
        if(amount > 1000)
        	throw new Exception("El monto maximo para operar es de 1000");
        
		this.amount = amount;
		this.card = card;
		this.rate = calculateRate(this.date, card);
		this.finalPrice = calculateFinalPrice(this.rate, this.amount);
	}

	public Float getTotal() {
		return amount;
	}
	
	public void setTotal(Float total) {
		this.amount = total;
	}
	
	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	public Float getTasa() {
		return rate;
	}
	
	public void setTasa(Float tasa) {
		this.rate = tasa;
	}
	
	public Float getFinalPrice() {
		return finalPrice;
	}
	
	public void setFinalPrice(Float finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static boolean validateCard(String date, Card card) {
		String[] saleDate = date.split("/");
		Integer saleMonth = Integer.parseInt(saleDate[1]);
		Integer saleYear = Integer.parseInt(saleDate[2]);
		Integer cardMonth = card.getExpirationDate().getMonth();
		Integer cardYear = card.getExpirationDate().getYear();
		
		if(cardMonth < saleMonth && cardYear < saleYear)
			return false;
		
		return true;
	}
	
	public static Float calculateRate(String date, Card card) {
		String[] saleDate = date.split("/");
		Integer saleDay = Integer.parseInt(saleDate[0]);
		Integer saleMonth = Integer.parseInt(saleDate[1]);
		Integer saleYear = Integer.parseInt(saleDate[2]);
		Float rate = 0f;
		
		if(card.getBrand()==Brand.VISA)
			rate = saleYear.floatValue()/saleMonth.floatValue();
		if(card.getBrand()==Brand.NARA)
			rate = saleDay.floatValue()*0.5f;
		if(card.getBrand()==Brand.AMEX)
			rate = saleMonth.floatValue()*0.1f;
			
		return rate;
	}
	
	public static Float calculateFinalPrice(Float rate, Float amount) {
		Float finalPrice = 0f;
		
		finalPrice = amount+amount*rate/100f;
		
		return finalPrice;
	}
	
	public static void simulateSale(Float amount, Card card) throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        String dateNow = dtf.format(LocalDateTime.now());
        
        if(!validateCard(dateNow, card)) 
        	throw new Exception("Tarjeta no valida para operar");
        if(amount > 1000)
        	throw new Exception("El monto maximo para operar es de 1000");
        
        Float rate = calculateRate(dateNow,card);
		System.out.println("Marca de la tarjeta: "+card.getBrand());
		System.out.println("Tasa de interes a dia de hoy: "+rate);
		System.out.println("Importe final a abonar: "+calculateFinalPrice(rate,amount));
	}
	
}
