package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chapter6.Trader;
import chapter6.Transaction;

public class Ch6 {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		Currency korean = new Currency("Won");
		Currency american = new Currency("Doller");
		Currency japanese = new Currency("Yen");
		Currency chinese = new Currency("Yuan");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300, american),
				new Transaction(raoul, 2012, 1000, korean),
				new Transaction(raoul, 2011, 400, korean),
				new Transaction(mario, 2012, 710, chinese),
				// new Transaction(mario, 2012, 700, japanese),
				new Transaction(alan, 2012, 950, chinese)
		);
		
		Map<Currency, List<Transaction>> transactionsByCurrencies 
			= new HashMap<>(); // 그룹화할 트랜잭션을 저장할 맵
		
		for(Transaction transaction: transactions) {
			System.out.println("....."+transactionsByCurrencies);
			Currency currency = transaction.getCurrency(); // 트랜잭션의 통화 추출
			List<Transaction> transactionsForCurrency = 
					transactionsByCurrencies.get(currency); // 1. 현재 통화를 그룹화하는 맵에 항목이 없으면
			if(transactionsForCurrency == null) { // 2. 검사해서 만든다.
				transactionsForCurrency = new ArrayList<>();
				transactionsByCurrencies.put(currency, transactionsForCurrency);
				System.out.println("if문 내부....."+transactionsByCurrencies);
			}
			transactionsForCurrency.add(transaction);
		}
		
		System.out.println(transactionsByCurrencies);
		
	}
	
	public static void test() {
		List<Transaction> transactions = new ArrayList<>();
		
		// Map<Currency, List<Transaction>> transactionsByCurrencies 
			// = transactions.stream().collect(groupingBy(Transaction::getCurrency));
		
	}

}
