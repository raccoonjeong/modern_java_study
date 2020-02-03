package chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Ch4Dot3Dot2 {
	// 외부 반복 : for-each 등 사용자가 직접 요소 반복 
	// 내부 반복 : 스트림 라이브러리가 알아서 처리하고 어딘가 저장해줌
	
	public static void main(String[] args) {
		useExternalIterationByForLoop(Dish.menu);
		useExternalIterationByIterator(Dish.menu);
		useInternalIterationByStream(Dish.menu);
	}
	
	public static void useExternalIterationByForLoop(List<Dish> menu) {
		// for루프 이융한 외부반복
		List<String> names = new ArrayList<>();
		for(Dish dish : menu) {
			names.add(dish.getName());
		}
		System.out.println(names);
	}
	public static void useExternalIterationByIterator(List<Dish> menu) {
		// 컬렉션 내부에 숨겨진 반복자를 이용한 외부 반복
		List<String> names = new ArrayList<>();
		Iterator<Dish> iterator = menu.iterator();
		while(iterator.hasNext()) {
			Dish dish = iterator.next();
			names.add(dish.getName());
		}
		System.out.println(names);
	}
	public static void useInternalIterationByStream(List<Dish> menu) {
		List<String> names = menu.stream()
							.map(Dish::getName)
							.collect(toList());
		System.out.println(names);
	}
	
}
