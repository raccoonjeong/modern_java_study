package chapter6;

import java.util.Objects;

public class Transaction {

	private Trader trader;
	private int year;
	private int value;

	private Currency currency;
	
	

	public Transaction(Trader trader, int year, int value, Currency currency) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}


	@SuppressWarnings("boxing")
	@Override
	public String toString() {
		return String.format("{%s, year: %d, value: %d}", trader, year, value, currency);
	}
	
	

}
