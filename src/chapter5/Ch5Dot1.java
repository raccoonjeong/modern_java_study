package chapter5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Ch5Dot1 {
	public static void main(String[] args) {
		filterBySpecificElement(Dish.menu);
	}
	public static void filterByPredicate(List<Dish> menu) {
		// 프레디케이트로 필터링
		List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
	}
	public static void filterBySpecificElement(List<Dish> menu) {
		// 고유 요소 반환하는 스트림 
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream().filter(i->i%2 == 0).distinct().forEach(System.out::println);
	}
}
