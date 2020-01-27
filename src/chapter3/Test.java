package chapter3;

import java.util.Comparator;

import chapter2.Apple;

public class Test {
	public static void main(String[] args) {
		Comparator<Apple> byWeight = new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		};
		// 람다를 이용한 Comparator 객체 구현
		Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
	
		/* 다섯가지 람다 표현식 예제 */
		// 1. (String s) -> s.length() 
		// String 형식의 파라미터 하나를 가지며 int를 반환. 람다표현식에는 return이 함축되어 있으므로 생략 가능
		
		// 2. (Apple a) -> a.getWeight() > 150
		// Apple 형식의 파라미터 하나를 가지며 boolean 반환.
		
		// 3. (int x, int y) -> {
		//  	System.out.println("Result : ");
		//	    System.out.println(x + y);
		// }
		// int 형식의 파라미터 두개를 가지며 리턴값 없음. 람다표현식에는 여러 행 문장 포함 가능
		
		// 4. () -> 42
		// 파라미터가 없으며 int 42를 반환
		
		// 5. (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())
		// Apple 형식의 파라미터 두개를 가지며 int 반환
		
		
		/* Runnable 구현 */
		// 함수형 인터페이스로 할 수 있는 것 : 
		// 전체 표현식을 함수형 인터페이스의 인스턴스로 취급. 이는 함수형 인터페이스를 *구현*한 클래스의 인스턴스
		
		Runnable r1 = () -> System.out.println("Hello world 1");
		Runnable r2 = new Runnable() {
			public void run() {
				System.out.println("Hello wolrd 2");
			}
		};
		
		process(r1);
		process(r2);
		process(()->System.out.println("Hello world 3"));
	}
	public static void process(Runnable r) {
		r.run();
	}
}
