package Class;

public class Card {
	public enum Brand{
		VISA,
		NARA,
		AMEX
	}
	private Brand brand;
	private Long cardNumber;
	private String cardholder;
	private ExpirationDate expirationDate;
	
	
	public Card(Brand brand, Long cardNumber, String cardholder, ExpirationDate expirationDate) {
		super();
		this.brand = brand;
		this.cardNumber = cardNumber;
		this.cardholder = cardholder;
		this.expirationDate = expirationDate;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public Long getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardholder() {
		return cardholder;
	}
	
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}
	
	public ExpirationDate getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(ExpirationDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public static void showCard(Card card) {
		System.out.println("Marca: "+card.getBrand());
		System.out.println("Numero: "+card.getCardNumber());
		System.out.println("Nombre y apellido: "+card.getCardholder());
		System.out.println("Fecha: "+card.getExpirationDate().getMonth()+"/"+card.getExpirationDate().getYear());
	}
	
	public static void compareCard(Card card1, Card card2) {
		if(card1.equals(card2))
			System.out.println("Las tarjetas son iguales");
		else 
			System.out.println("Las tarjetas no son iguales");
		
	}
}
