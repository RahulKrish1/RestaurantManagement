package tests;

import Restaurant.RestaurantDirector;

public class EachCustomerAverageTest {
    
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
		
		customerName = "James,LeBron";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 1, 1, 10.0);
		director.customerPaidAmount(customerName, 1, 2, 0);
        director.customerPaidAmount(customerName, 1, 3, 16.5);
        director.customerPaidAmount(customerName, 1, 4, 30.0);

        customerName = "Durant,Kevin";
		director.addCustomer(customerName);
		director.customerPaidAmount(customerName, 1, 1, 10.0);
		director.customerPaidAmount(customerName, 1, 2, 20.0);
        director.customerPaidAmount(customerName, 1, 3, 16.5);
        director.customerPaidAmount(customerName, 1, 4, 0.0);

        answer.append(director.getEachCustomerAverage());

		System.out.println(answer.toString());

    }

}
