package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ch5Dot5 {
	public static void main(String[] args) {
		// 리듀싱 연산 : 모든 스트림 요소를 처리해서 값으로 도출하는 것
		// 종이를 같은 모양으로 계속 접는 것 같다고 fold라고도 부름
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		findMaxMin(numbers);
		
		
	}
	public static void aboutReduce(List<Integer> numbers) {
		int sum = 0;
		for(int x : numbers) sum += x;
		System.out.println(sum);
		
		int sum2 = numbers.stream().reduce(0, (a,b) -> a+b); // params: 초기값 0, BinaryOperator<T>
		System.out.println(sum2);
		int product = numbers.stream().reduce(1,(a,b) -> a*b);
		System.out.println(product);
		
		// 더 간결하게 Integer의 정적 sum 메소드
		int sum3 = numbers.stream().reduce(0, Integer::sum);
		
		// 초기값을 안받는 reduce : Optional을 반환. 스트림에 아무 요소도 없는 상황을 대비함
		Optional<Integer> sum4 = numbers.stream().reduce((a,b) -> (a+b));
		
	}
	
	public static void findMaxMin(List<Integer> numbers) {
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		
		System.out.println("최대: "+ max.get() + "\n최소: "+min.get());
		
		
		
	}
}
