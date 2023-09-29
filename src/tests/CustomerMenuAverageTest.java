package tests;

import Restaurant.RestaurantDirector;

public class CustomerMenuAverageTest {
    
    public static void main(String[] args) {

        StringBuffer answer = new StringBuffer();
		RestaurantDirector director = new RestaurantDirector();
		
		/* First Menu */
		director.addMenu(1);
		director.addAppetizer(1, 1, "Shrimp Popcorn", 10.0);
		director.addAppetizer(1, 2, "Chips and Salsa", 20.0);
		director.addMainDish(1, 3, "Ribeye Steak", 16.5);
		director.addDessert(1, 4, "Chocolate Ice Cream", 30.0);
		
		String customerName = "Curry,Steph";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 1, 1, 0);
		director.customerPaidAmount(customerName, 1, 2, 0);
        director.customerPaidAmount(customerName, 1, 3, 16.5);
        director.customerPaidAmount(customerName, 1, 4, 30.0);
		
		/* Second Menu */
		director.addMenu(2);
		director.addAppetizer(2, 1, "Cheese Curds", 8.0);
		director.addAppetizer(2, 2, "Calamari", 22.0);
		director.addMainDish(2, 3, "Chicken Burger", 11.5);
		director.addDessert(2, 4, "Apple Pie", 15.0);

        director.customerPaidAmount(customerName, 2, 1, 8.0);
		director.customerPaidAmount(customerName, 2, 2, 0);
        director.customerPaidAmount(customerName, 2, 3, 11.5);
        director.customerPaidAmount(customerName, 2, 4, 15.0);

		answer.append("Orders for " + customerName + " " + director.getCustomerMenuAverage(customerName));
		answer.append("\nMenu #1: " + " " + director.getCustomerMenuPay(customerName, 1));
		answer.append("\n" + director.getMenuReport(customerName, 1));
		answer.append("\nMenu #2: " + " " + director.getCustomerMenuPay(customerName, 2));
		answer.append("\n" + director.getMenuReport(customerName, 2));

		System.out.println(answer.toString());

    }

}
