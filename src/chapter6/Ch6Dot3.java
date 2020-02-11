package chapter6;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Ch6Dot3 {
	
	public enum CaloricLevel {DIET, NORMAL, FAT}
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.menu;
		
		Map<Dish.Type, List<Dish>> dishesByType = 
				menu.stream().collect(groupingBy(Dish::getType));
		
		System.out.println(dishesByType);
		
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				groupingBy(dish -> {
					if(dish.getCalories() <= 400) return CaloricLevel.DIET;
					else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));
		
		Map<Dish.Type, List<Dish>> caloricDishesByType =
				menu.stream().filter(dish -> dish.getCalories() > 500)
							 .collect(groupingBy(Dish::getType));
		
		System.out.println(caloricDishesByType);
				
		
	}
}
