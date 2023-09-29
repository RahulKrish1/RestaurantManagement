package tests;

import Restaurant.RestaurantDirector;

public class AppetizerTest {

	public static void main (String[] args) {
	
		StringBuffer answer = new StringBuffer();
		RestaurantDirector director = new RestaurantDirector();
		director.addMenu(10);
		director.addAppetizer(10, 1, "Shrimp Popcorn", 6.0);
		director.addAppetizer(10, 2, "Cheese Curds", 7.50);
		director.addAppetizer(10, 3, "Chips and Salsa", 9.25);
		answer.append(director.getMenu(10));
		
		String customerName = "Curry,Steph";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 10, 1, 6.0);
		director.customerPaidAmount(customerName, 10, 2, 0);
		director.customerPaidAmount(customerName, 10, 3, 9.25);
		answer.append("Price for " + customerName + " " + director.getCustomerMenuPay(customerName, 10));
		
		customerName = "James,LeBron";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 10, 1, 0);
		director.customerPaidAmount(customerName, 10, 2, 7.50);
		director.customerPaidAmount(customerName, 10, 3, 9.25);
		answer.append("\nPrice for " + customerName + " " + director.getCustomerMenuPay(customerName, 10));
		
		customerName = "Durant,Kevin";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 10, 1, 6.0);
		director.customerPaidAmount(customerName, 10, 2, 7.50);
		director.customerPaidAmount(customerName, 10, 3, 0);
		answer.append("\nPrice for " + customerName + " " + director.getCustomerMenuPay(customerName, 10));
		
		System.out.println(answer.toString());
	}
	
}
