package chapter4;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Quiz {
	public static void main(String[] args) {
		Quiz4Dash1(Dish.menu);
		Quiz4Dash2(Dish.menu);
	}
	public static void Quiz4Dash1(List<Dish> menu) {
		// 외부 반복과 내부 반복
		List<String> highCaloricDishs = menu.stream()
											.filter(d->d.getCalories() > 300)
											.map(Dish::getName)
											.collect(toList());
		System.out.println(highCaloricDishs);
	}
	public static void Quiz4Dash2(List<Dish> menu) {
		// 중간 연산과 최종 연산
		long count = menu.stream()
						 .filter(d -> d.getCalories() > 300)
						 .distinct()
						 .limit(3)
						 .count();
		System.out.println("카운트는?!  : "+count);
		
	}
}
