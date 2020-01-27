package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test3 {
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for(T t : list) {
			if(p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T t : list) {
			c.accept(t);
		}
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for(T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("","dd","","aa");
		
		// 1. 제네릭 T를 받고 boolean 반환이 필요할 때 Predicate 인터페이스 활용.
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
		System.out.println(nonEmpty);
		
		// 2. 제네릭 T를 받고 void 반환 필요할 때 Consumer 인터페이스 활용.
		forEach( Arrays.asList(1,2,3,4,5),
				(Integer i) -> System.out.println(i)
 		);
		
		// 3. 제네릭 T를 받고 제네릭 R 반환 필요할 때 Function 인터페이스 활용.
		List<Integer> l = map(
				Arrays.asList("lambdas", "in", "action"),
				(String s) -> s.length()
		);
		System.out.println(l);
	}
}
