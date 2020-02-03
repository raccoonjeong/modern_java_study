package chapter5;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Ch5 {
	public static void main(String[] args) {
		
	}
	public static void useExternalIterationByForLoop(List<Dish> menu) {
		// 컬렉션 반복을 명시적으로 관리하는 외부 반복 코드
		List<Dish> vegetarianDishes = new ArrayList<>();
		for(Dish d : menu) {
			vegetarianDishes.add(d);
		}
		System.out.println(vegetarianDishes);
	}
	public static void useInternalIterationByStream(List<Dish> menu) {
		//  스트림 API를 이용한 내부 반복 코드
		List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());
		
	}

}
