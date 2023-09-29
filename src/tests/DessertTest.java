package tests;

import Restaurant.RestaurantDirector;

public class DessertTest {

	public static void main (String[] args) {
	
		StringBuffer answer = new StringBuffer();
		RestaurantDirector director = new RestaurantDirector();
		director.addMenu(12);
		director.addDessert(12, 1, "Chocolate Ice Cream", 8.50);
		director.addDessert(12, 2, "Red Velvet Cake", 6.0);
        director.addDessert(12, 3, "Apple Pie", 7.50);
		answer.append(director.getMenu(12));
		
		
		System.out.println(answer.toString());
	}
	
}
