package chapter3;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Quiz {
	public static void main(String[] args) {
		
	}
	
	public void testMethod() {
		// 다음 람다 표현식와 일치하는 메서드 참조를 구현하라
		// 문1
		ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
		// 답1
		ToIntFunction<String> stringToInt2 = Integer::parseInt;

		// 문1
		BiPredicate<List<String>, String> contains = (list,element) -> list.contains(element);
		// 답1
		BiPredicate<List<String>, String> contains2 = List::contains;
		
		// 문1
		Predicate<String> startsWithNumbers = (String string) -> this.startsWithNumber(string);
		// 답1
		Predicate<String> startsWithNumbers2 = this::startsWithNumber;
				
	}
	
	public boolean startsWithNumber(String s) {
		System.out.println("몰라");
		return true;
	}

}
