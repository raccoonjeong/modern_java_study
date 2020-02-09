package chapter6;

public class Currency {
	
	public String currency;

	public Currency(String currency) {
		super();
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Currency [currency=" + currency + "]";
	}

}
