package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import chapter2.Apple;
import chapter2.Color;
import static java.util.Comparator.comparing;
public class Test9 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(155, Color.BLUE),
				new Apple(20, Color.YELLOW),
				new Apple(90, Color.GREEN),
				new Apple(160, Color.RED),
				new Apple(46, Color.ZZZZZ),
				new Apple(46, Color.GREEN)
				);
		
		// 정적 메서드 comparing 을 이용하여 비교에 사용할 키를 추출하는 Function 기반의 Comparator
		Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
		// 역정렬.. 비교자의 순서를 바꾸는 메소드. 인터페이스에서 제공
		inventory.sort(comparing(Apple::getWeight).reversed());
		System.out.println(inventory);
		// 연결해서 비교
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
	}
}
