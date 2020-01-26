package part_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static void main(String...args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN),
											  new Apple(155, Color.GREEN),
											  new Apple(120, Color.RED));
		List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
		List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
		
		System.out.println("무거운사과고르기...");
		for(Apple apple : heavyApples) {
			System.out.println(apple.toString());
		}
		System.out.println("초록사과고르기...");
		for(Apple apple : greenApples) {
			System.out.println(apple.toString());
		}
	}
}
