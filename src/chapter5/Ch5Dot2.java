package chapter5;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Ch5Dot2 {
	public static void main(String[] args) {
		List<Dish> specialMenu = Arrays.asList(
				new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fried", true, 530, Dish.Type.OTHER)
				);
		
		// 이렇게 하면 큰 리스트일 때 부담...
		// List<Dish> filteredMenu = specialMenu.stream().filter(dish -> dish.getCalories() < 320).collect(toList());
		
	} 
	public static void takeWhile(List<Dish> specialMenu) {
		// 자바9 문법
		// List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(toList());
	}
	public static void dropWhile(List<Dish> specialMenu) {
		// 자바9 문법
		// List<Dish> slicedMenu1 = specialMenu.stream().While(dish -> dish.getCalories() < 320).collect(toList());
	}
	public static void reduceStream(List<Dish> specialMenu) {
		// limit(3) : 최대요소 n개 반환
		List<Dish> dishes = specialMenu.stream().filter(dish -> dish.getCalories() > 300)
									   .limit(3).collect(toList());
	}
	public static void skipElement(List<Dish> menu) {
		// 300칼로리 이상의 처음 두 요리 건너뜀
		List<Dish> dishes = menu.stream()
								.filter(d -> d.getCalories() > 300)
								.skip(2)
								.collect(toList());
	}
}
