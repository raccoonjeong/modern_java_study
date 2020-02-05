package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Quiz {
	public static void main(String[] args) {
		quiz5Dash3();
	}
	public static void quiz5Dash1() {
		List<Dish> specialMenu = Arrays.asList(
				new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fried", true, 530, Dish.Type.OTHER)
				);
		
		List<Dish> twoMeatDishes = specialMenu.stream()
				   .filter(d -> d.getType().equals(Dish.Type.MEAT))
				   .limit(2)
				   .collect(toList());
		
	}
	public static void quiz5Dash2Dash1() {
		// [1,2,3,4,5] -> [1,4,9,16,25] 제곱근 배열로 반환하기
		
		// Integer[] list = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		List<Integer> result = list.stream()
								   .map(i -> i = i*i)
								   .collect(toList());
		
		System.out.println(result);
		
	}
	public static void quiz5Dash2Dash2() {
		// 두 숫자 리스트의 모든 숫자쌍의 리스트를 구해라
		// [1,2,3] [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
		// List<Integer> + List<Integer> -> List<List<Integer>>
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		
		// 못풀어서 답 베낌
		List<int[]> pairs = list1.stream()
				.flatMap(i -> list2.stream().map(j -> new int[] {i, j}))
				.collect(toList());
		
		System.out.println(pairs);
		
	}
	public static void quiz5Dash2Dash3() {
		// 이전 예제 그대로 하는데 합이 3으로 나누어떨어지는 쌍만 반환하려면?
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		
		List<int[]> pairs = list1.stream()
					 .flatMap(i -> list2.stream()
							 			.filter(j -> (i+j)%3 == 0)
							 			.map(k -> { System.out.println(i + ".." + k); return new int[] {i, k};}))
					 .collect(toList());
		System.out.println(pairs);
	}
	public static void quiz5Dash3() {
		// map, reduce로 스트림의 요리갯수 구하기.
		List<Dish> menu = Dish.menu;
		menu.size(); //?
		
		// int count = 0;
		// 틀림 : menu.stream().map(d -> 1).reduce(0, (a,b) -> count + b);
		int count = menu.stream().map(d -> 1).reduce(0, (a,b) -> a + b);
		
		System.out.println(count);
	}
}
