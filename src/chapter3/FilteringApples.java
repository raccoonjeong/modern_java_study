package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilteringApples {
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T e : list) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
	
	public static void main(String...args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN),
											  new Apple(155, Color.GREEN),
											  new Apple(120, Color.RED));
		System.out.println("정렬 전 순서를 봅시다");
		for(Apple apple : inventory) {
			System.out.println(apple);
		}
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		
		System.out.println("정렬 후 순서를 봅시다");
		for(Apple apple : inventory) {
			System.out.println(apple);
		}
	}
}
