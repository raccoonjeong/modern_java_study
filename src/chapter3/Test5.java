package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import chapter2.Apple;
import chapter2.Color;
import chapter2.Predicate;

public class Test5 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN),
				  new Apple(155, Color.GREEN),
				  new Apple(120, Color.RED));
		
		// 형식 추론.. apple에 타입을 명시하지 않았으나 컴파일러가 추론함
		List<Apple> greenApples = filter(inventory, apple -> Color.GREEN.equals(apple.getColor()));
		
		// 상황에 따라 골라쓰면 된다.
		Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		Comparator<Apple> c2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
		
		
		
		
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
