package chapter6;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
import java.util.Comparator;
import java.util.HashMap;

public class Ch6Dot3 {
	
	public enum CaloricLevel {DIET, NORMAL, FAT}
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.menu;
		
		// System.out.println(menu);
		Map<Dish.Type, List<Dish>> dishesByType = 
				menu.stream().collect(groupingBy(Dish::getType));
		
		
		// System.out.println(dishesByType);
		
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				groupingBy(dish -> {
					if(dish.getCalories() <= 400) return CaloricLevel.DIET;
					else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));
		
		Map<Dish.Type, List<Dish>> caloricDishesByType =
				menu.stream().filter(dish -> dish.getCalories() > 500)
							 .collect(groupingBy(Dish::getType));
		
		// System.out.println(caloricDishesByType);
		
//		Map<Dish.Type, List<Dish>> caloricDishesByType2 =
//				menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
		
		Map<Dish.Type, List<String>> dishNamesByType = 
				menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
		
		// System.out.println(dishNamesByType);
		
		Map<String, List<String>> dishTags = Dish.dishTags;
		
		// System.out.println(dishTags);
		
//		Map<Dish.Type, Set<String>> dishNamesByType2 = 
//				menu.stream().collect(groupingBy(Dish::getType,
//						flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
		
		
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
				menu.stream().collect(
						groupingBy(Dish::getType,
							groupingBy(dish -> {
								if (dish.getCalories() <= 400)
									return CaloricLevel.DIET;
								else if (dish.getCalories() <= 700)
									return CaloricLevel.NORMAL; else return CaloricLevel.FAT;
							})
						)
					);
		// System.out.println(dishesByTypeCaloricLevel);
		
		Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		
		// System.out.println(typesCount);
		
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = 
				menu.stream().collect(groupingBy(Dish::getType,
												maxBy(comparingInt(Dish::getCalories))));;
		// System.out.println(mostCaloricByType);
												
		Map<Dish.Type, Dish> mostCaloricByType2 =
				menu.stream()
					.collect(groupingBy(Dish::getType,
							 collectingAndThen(
									 maxBy(comparingInt(Dish::getCalories)),
							 Optional::get)));
		
		System.out.println(mostCaloricByType2);
		
		
		
		
		
	}
}
