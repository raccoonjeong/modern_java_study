package chapter5;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ch5Dot8 {
	// 스트림 만들기
	public static void main(String[] args) {
		// 5.8.1 - 값으로 스트림 만들기
		Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
		// 스트림 비우기... 비워진 스트림 만들기?
		Stream<String> emptyStream = Stream.empty();
		
		// 5.8.2 - null이 될 수 있는 객체로 스트림 만들기
		String homeValue = System.getProperty("user.dir"); // home이면 null
		Stream<String> homeValueStream = homeValue == null ? // null을 명시적으로 확인한다.
										 Stream.empty() : Stream.of(homeValue);
        
		// 자바 9 문법 - 좀더 간단하게 처리. ofNullable
		// Stream<String> homeValueStream2 = Stream.ofNullable(System.getProperty("home"));
        
        // Stream<String> values = Stream.of("config", "home", "user")
        		//.flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        						     						 
										 
	}

}
