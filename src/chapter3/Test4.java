package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Test4 {
	public static void main(String[] args) {
		IntPredicate evenNumbers = (int i) -> i % 2 == 0;
		System.out.println(evenNumbers.test(1000)); // 박싱 X
		
		Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
		System.out.println(oddNumbers.test(1000)); // 박싱 O
		
		/* 예외, 람다, 함수형 인터페이스의 관게
		* 예외를 던지는 람다표현식을 만들려면 확인된 예외를 선언하는 함수형 인터페이스를 직접 정의하거나 람다를 try/catch로 감싸야함.
		* 그러나 직접 함수형 인터페이스를 만들 수 없을 때 아래와 같은 방식으로 예외잡기
		*/
		Function<BufferedReader, String> f = (BufferedReader b) -> {
			try {
				return b.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		};
	}
}
