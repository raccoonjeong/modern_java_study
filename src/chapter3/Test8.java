package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

import chapter2.Apple;
import chapter2.Color;

public class Test8 {
	public static void main(String[] args) {
		/* sort 메서드에 정렬 전략 전달하기! */
		
		// sort 메서드의 기본 시그니처
		// void sort(Comparator<? super E> c)
		
		List<Apple> inventory = Arrays.asList(new Apple(155, Color.BLUE),
											new Apple(20, Color.YELLOW),
											new Apple(90, Color.GREEN),
											new Apple(160, Color.RED),
											new Apple(46, Color.GREEN));
		// 1단계 : 코드 전달. AppleComparator 클래스 구현
		inventory.sort(new AppleComparator());
		
		// 2단계 : 익명 클래스 사용
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		
		// 3단계 : 람다 표현식 사용
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		// 컴파일러는 파라미터형식 추론 가능. 고로
		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		// Comparable 키를 추출해서 Comparator 객체로 만드는 Function 함수를 인수로 받는 정적메서드 : comparing
		Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
		// 이를 더 간소화
		inventory.sort((comparing(apple->apple.getWeight())));

		// 4단계 : 메서드 참조 사용
		inventory.sort(comparing(Apple::getWeight));
		// --> 의미가 더 명확해졌다! "Apple을 weight별로 비교해서 inventory를 sort하라"
	}
}
