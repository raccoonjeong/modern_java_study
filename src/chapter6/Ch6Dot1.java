package chapter6;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Ch6Dot1 {
	public static void main(String[] args) {
		
		List<Dish> menu = Dish.menu;
		long howManyDishes = menu.stream().collect(Collectors.counting());
		
		long howManyDishes2 = menu.stream().count();
		
		
		
	}
}
