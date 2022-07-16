package Class;

public class ExpirationDate {
	private Integer month;
	private Integer year;
	
	
	public ExpirationDate(Integer month, Integer year) {
		if(month < 1 || month > 12)
			 throw new ArithmeticException("El mes no puede ser menor a 1 ni mayor a 12");
		if(year < 1 || year > 99)
			 throw new ArithmeticException("El mes no puede ser menor a 1 ni mayor a 99");
		this.month = month;
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
}
