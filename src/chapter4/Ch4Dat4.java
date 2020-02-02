package chapter4;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class Ch4Dat4 {

	public static void main(String[] args) {
		showIntermediateOperation(Dish.menu);
		showTerminalOperation(Dish.menu);
	}
	public static void showIntermediateOperation(List<Dish> menu) {
		// 중간 연산
		List<String> names = menu.stream().filter(dish -> {
			System.out.println("filtering: "+ dish.getName());
			return dish.getCalories() > 300;
		})
		.map(dish->{
			System.out.println("mapping: "+dish.getName());
			return dish.getName();
		})
		.limit(3).collect(toList());
		System.out.println(names);
	}
	public static void showTerminalOperation(List<Dish> menu) {
		// 최종 연산
		menu.stream().forEach(System.out::println);
	}
	
}
