package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import chapter2.Apple;
import chapter2.Color;

public class Test7 {
	public static void main(String[] args) {
		
		/* 생성자도 참조가능해용 */
		Supplier<Apple> c1 = () -> new Apple();
		Apple a1 = c1.get();
		
		Supplier<Apple> c2 = Apple::new;
		Apple a2 = c2.get();
		
		/* Function 인터페이스 시그니처 */
		Function<Integer, Apple> c3 = (weight) -> new Apple(weight);
		Apple a3 = c3.apply(110);
		
		Function<Integer, Apple> c4 = Apple::new;
		Apple a4 = c4.apply(110);
		
		List<Integer> weights = Arrays.asList(7,3,4,10);
		List<Apple> apples = map(weights, Apple::new);
		
		/* 인수 2개 생성자 */
		BiFunction<Integer, Color, Apple> c5 = (weight, color) -> new Apple(weight, color);
		Apple a5 = c5.apply(110, Color.GREEN);
		
		BiFunction<Integer, Color, Apple> c6 = Apple::new;
		Apple a6 = c6.apply(110, Color.GREEN);
			
	}
	/* 인스턴스화하지 않고도 생성자에 접근할 수 있는 다양한 상황 1 */
	static Map<String, Function<Integer, Fruit>> map2 = new HashMap<>();
	static {
		map2.put("apple", Apple::new);
		// map2.put("apple", Orange::new);
		// 등등
	}
	
	/* 인스턴스화하지 않고도 생성자에 접근할 수 있는 다양한 상황 2
	 * String과 Integer가 주어졌을 때 다양한 무게를 갖는 여러 종류의 과일을 만듦*/
	public static Fruit giveMeFruit(String fruit, Integer weight) {
		return map2.get(fruit.toLowerCase()).apply(weight);
		// 맵에서 Function<Integer, Fruit>를 얻고, apply메서드에 정수를 제공해서 Fruit를 만든다.
	}
	
	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for(Integer i : list) {
			result.add(f.apply(i));
		}
		return result;
	}
}
