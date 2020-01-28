package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import chapter2.Apple;
import chapter2.Color;
import chapter2.Predicate;

public class Test6 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN),
				  new Apple(155, Color.GREEN),
				  new Apple(120, Color.RED));
		
		// 지역 변수 사용
		int portNumber = 1337;
		Runnable r = () -> System.out.println(portNumber);
		// portNumber = 13338; 안됨!!
		r.run();
		
		// 메서드 참조.. 람다보다 메서드 참조를 사용하는 게 더 가독성 좋고 자연스러울 수 있다.
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		// inventory.sort(comparing(Apple::getWeight)); // 왜 에러나지?
	
		// 메소드 참조2
		List<String> str = Arrays.asList("a","b","c","d");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		str.sort(String::compareToIgnoreCase);
				
	}
	
	public void testMethod() {
		// 메소드 참조1
		List<String> words = Arrays.asList("apple", "cat", "dog");
		filter(words, this::isValidName);
	}
	private boolean isValidName(String string) {
		return Character.isUpperCase(string.charAt(0));
	}
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T e : list) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
