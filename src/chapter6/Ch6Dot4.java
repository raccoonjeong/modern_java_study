package chapter6;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Ch6Dot4 {

	public static void main(String[] args) {
		List<Dish> menu = Dish.menu;
		Map<Boolean, List<Dish>> partitionedMenu = 
				menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(partitionedMenu);
		
		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType
			= menu.stream().collect(partitioningBy(Dish::isVegetarian,
									groupingBy(Dish::getType)));
		
		System.out.println(vegetarianDishesByType);
		
		
	}
}
