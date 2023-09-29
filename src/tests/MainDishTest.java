package tests;

import Restaurant.RestaurantDirector;

public class MainDishTest {

	public static void main (String[] args) {
	
		StringBuffer answer = new StringBuffer();
		RestaurantDirector director = new RestaurantDirector();
		director.addMenu(11);
		director.addMainDish(11, 1, "Ribeye Steak", 16.50);
		director.addMainDish(11, 2, "Chicken Burger", 12.75);
		director.addMainDish(11, 3, "Alfredo Pasta", 18.0);
        director.addMainDish(11, 4, "Lobster Ravioli", 22.5);
		answer.append(director.getMenu(11));
		
		
		System.out.println(answer.toString());
	}
	
}
