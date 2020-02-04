package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// 검색과 매칭
public class Ch5Dot4 {
	public static void main(String[] args) {
		// 쇼트서킷 기법.. &&, || 같은 연산
		// : 모든 요소를 처리하지 않더라도 결과를 반환할 수 있는 기법!! 
		List<Dish> menu = Dish.menu;
		
		// 1. 적어도 한 요소 일치하는지? : anyMatch
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("메뉴는 채식주의자 어쩌고 저쩌고");
		}
		// 2. 모든 요소 일치하는지? : allMatch
		boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
		System.out.println(isHealthy);
		
		// 3. 모든 요소 불일치하는지? : noneMatch
		boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
		System.out.println(isHealthy2);
		
		findFirstElement(menu);
		
	}
	
	public static void findElement(List<Dish> menu) {
		// 요소 검색
		Optional<Dish> dish = menu.stream()
								  .filter(Dish::isVegetarian)
								  .findAny();
		// 결과 찾는 즉시 실행 중단
		// Optional... 값의 존재나 부재 여부를 표현할 수 있는 컨테이너임.
		// null로 인한 오류를 피하기 위해 만들어졌다.
		menu.stream()
		    .filter(Dish::isVegetarian)
		    .findAny() // Optional 반환
		    .ifPresent(d -> 
		    		System.out.println(d.getName())); // Optional의 기능. 값이 있어야만 해당 블록 실행
			// 널체크 따로 안해도 되서 넘 편함	
	}
	
	public static void findFirstElement(List<Dish> menu) {
		// 이미 논리적인 순서가 정해져있는 스트림일때, 첫번째 요소를 찾으려면?
		List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
		Optional<Integer> firstSquareDivisibleByThree =
				someNumbers.stream()
						   .map(n -> n*n)
						   .filter(n->n%3 == 0)
						   .findFirst();
		firstSquareDivisibleByThree.ifPresent(i->System.out.println(i));
	}
	

}
