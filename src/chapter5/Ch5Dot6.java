package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class Ch5Dot6 {
	public static void main(String[] args) {
		question8();
	}
	
	public static void question1() {
		// 2011 모든 트랜잭션 찾아 값 오름차순으로 정리. -- 틀림!
		// 의문.. filter와 allMatch 차이?
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		transactions.stream()
					.filter(t->t.getYear() == 2011)
					.sorted(comparing(Transaction::getValue))
					.collect(toList());
	}
	public static void question2() {
		// 거래자가 근무하는 모든 도시를 중복없이 나열하라. -- 맞음!
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		List<String> list = 
		transactions.stream().map(x -> x.getTrader().getCity())
					.distinct()
					.collect(toList());
	
		System.out.println(list);
	}
	
	public static void question3() {
		// 켐브리지에서 근무하는 모든 거래처를 찾아 이름순으로 정렬해라. -- 틀림!
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
//		List<Optional<String>> list = transactions.stream()
//					.map(tran -> tran.getTrader())
//					.filter(trader -> trader.getCity().equals("Cambridge"))
//					.distinct()
//					.sorted(comparing(Trader::getName))
//					.collect(toList());
		List<Trader> traders = 
				transactions.stream()
							.map(Transaction::getTrader)
							.filter(trader -> trader.getCity().equals("Cambridge"))
							.distinct()
							.sorted(comparing(Trader::getName))
							.collect(toList());
		System.out.println(traders);
	}
	
	public static void question4() {
		// 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하라. -- 틀림
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		List<String> list = transactions.stream()
					.map(Transaction::getTrader)
					.distinct()
					.sorted(comparing(Trader::getName))
					.map(Trader::getName).collect(toList());
		
		System.out.println(list); // 틀림
		
		String s = transactions.stream()
				.map(Transaction::getTrader)
				.map(Trader::getName)
				.distinct()
				.sorted()
				.reduce("", (n1, n2) -> n1 + n2);
		System.out.println(s);	
	}
	public static void question5() {
		// 밀라노에 거래자가 있는가? -- 맞긴함
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		boolean result = transactions.stream()
									 .map(Transaction::getTrader)
									 .anyMatch(t -> t.getCity().equals("Milan"));
		System.out.println(result); // 정답이랑 스타일 다름
		
		// 정답
		boolean milanBased = 
				transactions.stream()
							.anyMatch(t->t.getTrader()
										  .getCity()
										  .equals("Milan"));
		System.out.println(milanBased);
	}
	
	public static void question6() {
		// 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력해라. -- 맞긴함
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		transactions.stream()
					.filter(t->t.getTrader().getCity().equals("Cambridge"))
					.forEach(System.out::println);
	}
	
	public static void question7() {
		// 전체 트랜잭션 중 최댓값은 얼마인가?
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		int s = transactions.stream()
					.map(Transaction::getValue)
					.reduce(Integer::max).get();
		System.out.println(s);
		
	}
	public static void question8() {
		// 최소값
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		int s = transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::min).get();
	System.out.println(s);
	}
}
