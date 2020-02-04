package chapter5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Ch5Dot3 {
	public static void main(String[] args) {
		flatteningStream();
		
	}
	public static void applyFunctionToEachElement(List<Dish> menu) {
		// 각 요소에 함수 적용하기
		List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
		List<Integer> wordLengths = words.stream()
										 .map(String::length)
										 .collect(toList());
		System.out.println(wordLengths);
		
		List<Integer> dishNameLengths = menu.stream()
											.map(Dish::getName)
											.map(String::length)
											.collect(toList());
		
		System.out.println(dishNameLengths);
	}
	public static void flatteningStream() {
		// 리스트의 고유 문자로 이루어진 리스트 반환하기.. 기대결과 : ["H", "e", "l", "o", "W", "r", "d"]
		List<String> words = Arrays.asList("Hello", "World");
		
		// List<String> result = words.stream().map(word->word.split("")).map(Arrays::toString).collect(toList());
		
		/* 1. map과 distinct만 이용했을 때 */
		List<String[]> result1 = words.stream()
									 .map(word->word.split(""))
									 .distinct()
									 .collect(toList());
		System.out.println(result1); // 실패함. 왜냐? 위의 map은 String[] 을 반환하기 때문.
		// 위의 map은 배열 스트림을 반환한다!!
		
		/* 2. map과 Arrays.stream 활용 */
		List<Stream<String>> result2 = words.stream()
		 .map(word -> word.split(""))
		 .map(Arrays::stream) // 각 배열을 별도의 스트림으로 생성
		 .distinct()
		 .collect(toList());
		
		System.out.println(result2); // 실패함. 왜냐? 엄밀히 Stream<String>의 리스트를 반환하게 되는 것
		// 문제 해결을 위해서는 각 단어를 개별 문자열로 이루어진 배열로 만든 이후 각 배열을 별도의 스트림으로 만들어야한다!
		// Stream<String[]> ?
		
		/* 3. flatMap 사용 */
		List<String> uniqueCharacters = 
				words.stream()
				     .map(word -> word.split(""))
				     .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
				     .distinct()
				     .collect(toList());
		
		System.out.println(uniqueCharacters); // 성공!!
		
		
	}

}
