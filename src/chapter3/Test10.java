package chapter3;

import java.util.function.Function;
import java.util.function.Predicate;

import chapter2.Apple;
import chapter2.Color;

public class Test10 {
	public static void main(String[] args) {
		// Predicate 조합
		// 1. negate
		Predicate<Apple> redApple = a -> a.getColor().equals(Color.RED);
		Predicate<Apple> notRedApple = redApple.negate(); // 반전결과
		// 2. and
		Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);
		// 3. or
		Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(apple -> apple.getWeight() > 150)
															.or(apple -> apple.getColor().equals(Color.GREEN));
		
		// Function 조합
		// 1. andThen : 주어진 함수를 먼저 적용한 결과를 다른 함수의 입력으로 전달하는 함수 반환
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;;
		Function<Integer, Integer> h = f.andThen(g); // 수학에서 g(f(x)) 
		int result1 = h.apply(1); // 4 반환
		System.out.println(result1);
		Function<Integer, Integer> j = f.compose(g); // 수학에서 f(g(x))
		int result2 = j.apply(1); // 3 반환
		System.out.println(result2);
		
	}
}
