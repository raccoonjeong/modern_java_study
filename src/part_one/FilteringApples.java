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
		List<Apple> result = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
	}
}
