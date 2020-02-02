package chapter4;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Ch4Dat2 {
	public static void main(String[] args) {
		test(Dish.menu);	
	}
	public static void test(List<Dish> menu) {
		List<String> threeHighCaloricDishNames = 
				menu.stream().filter(dish -> dish.getCalories() > 300)
				.map(Dish::getName)
				.limit(3)
				.collect(toList());
		
		System.out.println(threeHighCaloricDishNames);
	}
}
