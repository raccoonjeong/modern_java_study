package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Ch4Dat1 {
	public static void main(String[] args) {
		
		System.out.println(originCode(Dish.menu));
		
	}
	public static List<String> originCode(List<Dish> menu) {
		// 자바7의 코드
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for(Dish dish : menu) {
			if(dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}
		
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			public int compare(Dish dish1, Dish dish2) {
				return Integer.compare(dish1.getCalories(), dish2.getCalories());
			}
		});
		
		List<String> lowCaloricDishesName = new ArrayList<>();
		for(Dish dish : lowCaloricDishes) {
			lowCaloricDishesName.add(dish.getName());
		}
		return lowCaloricDishesName;
	}
	
	public static List<String> java8Code(List<Dish> menu){
		List<String> lowCaloricDishesName = menu.stream().filter(d -> d.getCalories() < 400)
														 .sorted(comparing(Dish::getCalories))
														 .map(Dish::getName) 
														 .collect(toList()); 
		
		// 병렬 실행
		List<String> lowCaloricDishesName2 = menu.parallelStream()
														  .filter(d -> d.getCalories() < 400)
														  .sorted(comparing(Dish::getCalories))
														  .map(Dish::getName) 
														  .collect(toList()); 
		
		return null;
	}
}
