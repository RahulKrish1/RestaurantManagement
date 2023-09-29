package tests;

import Restaurant.RestaurantDirector;

public class DessertReportTest {

	public static void main (String[] args) {
	
		StringBuffer answer = new StringBuffer();
		RestaurantDirector director = new RestaurantDirector();
		director.addMenu(12);
		director.addDessert(12, 1, "Chocolate Ice Cream", 8.50);
		director.addDessert(12, 2, "Red Velvet Cake", 6.0);
        director.addDessert(12, 3, "Apple Pie", 7.50);
		
		String customerName = "Curry,Steph";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 12, 1, 0);
		director.customerPaidAmount(customerName, 12, 2, 6.0);
		director.customerPaidAmount(customerName, 12, 3, 0);
		answer.append("\nReport for " + customerName + "\n" + director.getMenuReport(customerName, 12));

		customerName = "James,LeBron";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 12, 1, 0);
		director.customerPaidAmount(customerName, 12, 2, 6.0);
		director.customerPaidAmount(customerName, 12, 3, 7.50);
		answer.append("\nReport for " + customerName + "\n" + director.getMenuReport(customerName, 12));
		
		System.out.println(answer.toString());
	}
	
}
