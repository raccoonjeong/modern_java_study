package chapter5;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Quiz {
	public static void main(String[] args) {
		
	}
	public static void quiz5Dash1() {
		List<Dish> specialMenu = Arrays.asList(
				new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fried", true, 530, Dish.Type.OTHER)
				);
		
		List<Dish> twoMeatDishes = specialMenu.stream()
				   .filter(d -> d.getType().equals(Dish.Type.MEAT))
				   .limit(2)
				   .collect(toList());
		
	}

}
