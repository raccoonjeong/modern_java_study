package chapter4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ch4Dot3Dot1 {
	public static void main(String[] args) {
		// 스트림은 한번만 탐색 가능. 심지어 데이터소스가 I/O라면 반복사용할 수 없으므로 새로운 스트림을 만들 수 없음.
		List<String> title = Arrays.asList("Java8", "In", "Action");
		Stream<String> s = title.stream();
		
		s.forEach(System.out::println);
		//s.forEach(System.out::println); // 스트림이 이미 소비되어 오류발생
	
		
		// I/O라면 반복 불가
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> title2 = null;
		try {
			title2 = Arrays.asList(br.readLine());
			
		} catch(Exception e) {
			
		} finally {
			try {br.close();}catch(Exception e) {}
		}
		Stream<String> s2 = title2.stream();
		s2.forEach(System.out::println);
		
		
		List<String> title3 = null;
		try {
			title3 = Arrays.asList(br.readLine());
			
		} catch(Exception e) {
			
		} finally {
			try {br.close();}catch(Exception e) {}
		}
		Stream<String> s3 = title3.stream();
		s3.forEach(System.out::println);
		
	}

}
