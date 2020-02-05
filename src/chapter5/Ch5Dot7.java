package chapter5;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch5Dot7 {
	
	
	public static void main(String[] args) {
		three();
		List<Dish> menu = Dish.menu;
		/* 기본형 특화 스트림 */
		// 1. 숫자 스트림으로 매핑
		int calories = menu.stream() // Stream<Dish> 반환
						   .mapToInt(Dish::getCalories) // IntStream 반환
						   .sum();
		
		// 2. 객체 스트림으로 복원
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> stream = intStream.boxed(); 
		
		// 3. 기본값 : OptionalInt
		OptionalInt maxCalories = menu.stream()
									  .mapToInt(Dish::getCalories)
									  .max();
		int max = maxCalories.orElse(1); // 값이 없을 때 기본 최댓값을 명시적으로 설정함
		
		/* 숫자 범위 */
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
										 .filter(n -> n % 2 == 0);
	}
	
	public static void three() {
		
		Stream<int[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 100).boxed()
						 .flatMap(a -> 
							 IntStream.rangeClosed(a, 100)
								 	  .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0) // a,b 제곱 덧셈의 제곱근이 정수인 것 찾기
								 	  .mapToObj(b -> 
								 			  new int[] {a, b, (int)Math.sqrt(a*a + b*b)})
						 );
	
		pythagoreanTriples.limit(5)
						  .forEach(t -> 
								  System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
		
	}
	
	public static void advancedThree() {
		// 제곱근을 두번 계산하지 않고, 세 수를 만든 후 조건에 맞는 결과만 필터링하게끔.
		Stream<double[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 100).boxed()
						.flatMap(a -> IntStream.rangeClosed(1, 100)
											   .mapToObj(b -> new double[] {a, b, Math.sqrt(a*a + b*b)})
						.filter(t -> t[2] % 1 == 0));
	
		pythagoreanTriples.limit(5)
						  .forEach(t -> 
								  System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
		
	}
}
