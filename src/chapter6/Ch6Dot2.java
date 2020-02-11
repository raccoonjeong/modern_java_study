package chapter6;

import static java.util.stream.Collectors.*;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

public class Ch6Dot2 {
	public static void main(String[] args) {
		
		List<Dish> menu = Dish.menu;		
		// 메뉴에서 칼로리가 가장 높은 요리 찾기
		Comparator<Dish> dishCaloriesComparator = 
				Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCalorieDish = 
				menu.stream().collect(maxBy(dishCaloriesComparator));
		
		// 6.2.2 요약 연산
		
		// 메뉴 리스트의 총 칼로리 계산하기
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		
		
		IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		
		// System.out.println(menuStatistics);
		
		// 6.2.3 문자열 연결
		// joining 팩토리 메서드
		 String shortMenu = menu.stream().map(Dish::getName).collect(joining());
		 
		
		 // String shortMenu2 = menu.stream().collect(joining()); // ???
		
		 String shortMenu3 = menu.stream().map(Dish::getName).collect(joining(","));
		 System.out.println(shortMenu3);
		 
		 // 칼로리 합 구하기
		 int totalCalories2 = 
				 menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
		 
		 // 칼로리 최대값 구하기
		 Optional<Dish> mostCalorieDish2 = 
				 menu.stream().collect(reducing(
						 (d1, d2) -> d1.getCalories() > d2.getCalories()? d1 : d2));
		 
		 int totalCalories3 = 
				 menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
		 
		 int totalCalories4 = 
				 menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		 
		 int totalCalories5 = 
				 menu.stream().mapToInt(Dish::getCalories).sum();
	
	}
	public static <T> Collector<T, ?, Long> counting() {
		return reducing(0L, e -> 1L, Long::sum);
	}
}
