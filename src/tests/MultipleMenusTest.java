package tests;

import java.util.ArrayList;

import Restaurant.RestaurantDirector;

public class MultipleMenusTest {

    public static void main(String[] args) {

        StringBuffer answer = new StringBuffer();
		RestaurantDirector director = new RestaurantDirector();
		String steph = "Curry,Steph";
		String lebron = "James,LeBron";
		String kevin = "Durant,Kevin";
		
		/* Adding Customers */
		director.addCustomer(steph);
		director.addCustomer(lebron);
        director.addCustomer(kevin);
		
		/* First Menu */
		int menuId = 1;
		director.addMenu(menuId);
		
		director.addAppetizer(menuId, 1, "Shrimp Popcorn", 10.0);
		director.addAppetizer(menuId, 2, "Chips and Salsa", 20.0);
		director.addMainDish(menuId, 3, "Ribeye Steak", 16.5);
		director.addDessert(menuId, 4, "Chocolate Ice Cream", 30.0);
				
		/* Amounts */
		menuId = 1;
		director.customerPaidAmount(steph, menuId, 1, 0);
		director.customerPaidAmount(steph, menuId, 2, 0);
        director.customerPaidAmount(steph, menuId, 3, 16.5);
        director.customerPaidAmount(steph, menuId, 4, 30.0);
		
		director.customerPaidAmount(lebron, menuId, 1, 10.0);
		director.customerPaidAmount(lebron, menuId, 2, 0);
        director.customerPaidAmount(lebron, menuId, 3, 16.5);
        director.customerPaidAmount(lebron, menuId, 4, 30.0);
		
		director.customerPaidAmount(kevin, menuId, 1, 10.0);
		director.customerPaidAmount(kevin, menuId, 2, 20.0);
        director.customerPaidAmount(kevin, menuId, 3, 16.5);
        director.customerPaidAmount(kevin, menuId, 4, 0.0);
		
		/* Second Menu */
		menuId = 2;
        director.addMenu(menuId);
		director.addAppetizer(menuId, 1, "Cheese Curds", 5.50);
		director.addAppetizer(menuId, 2, "Calamari", 11.25);
		director.addMainDish(menuId, 3, "Chicken Burger", 23.5);
		director.addDessert(menuId, 4, "Red Velvet Cake", 14.0);	

		/* Amounts */
		menuId = 2;
		director.customerPaidAmount(steph, menuId, 1, 0);
		director.customerPaidAmount(steph, menuId, 2, 11.25);
        director.customerPaidAmount(steph, menuId, 3, 23.5);
        director.customerPaidAmount(steph, menuId, 4, 0);
		
		director.customerPaidAmount(lebron, menuId, 1, 5.50);
		director.customerPaidAmount(lebron, menuId, 2, 11.25);
        director.customerPaidAmount(lebron, menuId, 3, 23.5);
        director.customerPaidAmount(lebron, menuId, 4, 0);
		
		director.customerPaidAmount(kevin, menuId, 1, 0);
		director.customerPaidAmount(kevin, menuId, 2, 11.25);
        director.customerPaidAmount(kevin, menuId, 3, 23.5);
        director.customerPaidAmount(kevin, menuId, 4, 14.0);
		
		/* Third Menu */
		menuId = 3;
		director.addMenu(menuId);
		director.addAppetizer(menuId, 1, "Mozarella Sticks", 7.25);
		director.addAppetizer(menuId, 2, "Garlic Bread", 8.25);
		director.addMainDish(menuId, 3, "Lobster Ravioli", 18.75);
		director.addDessert(menuId, 4, "Apple Pie", 13.25);		
		
		/* Amounts */
		menuId = 3;
		director.customerPaidAmount(steph, menuId, 1, 0);
		director.customerPaidAmount(steph, menuId, 2, 0);
        director.customerPaidAmount(steph, menuId, 3, 18.75);
        director.customerPaidAmount(steph, menuId, 4, 0);
		
		director.customerPaidAmount(lebron, menuId, 1, 7.25);
		director.customerPaidAmount(lebron, menuId, 2, 0);
        director.customerPaidAmount(lebron, menuId, 3, 0);
        director.customerPaidAmount(lebron, menuId, 4, 13.25);

		director.customerPaidAmount(kevin, menuId, 1, 0);
		director.customerPaidAmount(kevin, menuId, 2, 8.25);
        director.customerPaidAmount(kevin, menuId, 3, 18.75);
        director.customerPaidAmount(kevin, menuId, 4, 0);
	
		ArrayList<String> list = new ArrayList<String>();
		list.add(steph);
		list.add(lebron);
		list.add(kevin);
		for (menuId = 1; menuId <= 3; menuId++) {
			for (String customer : list) {
                director.getMenuReport(customer, menuId);
				answer.append("Report for " + customer + " Menu # " + menuId + "\n" + director.getMenuReport(customer, menuId) + "\n\n");
			}
		}
		
		for (menuId = 1; menuId <= 3; menuId++) {
			answer.append("Minimum for Menu # " + menuId + " " + director.getMinAmount(menuId) + "\n");
			answer.append("Maximum for Menu # " + menuId + " " + director.getMaxAmount(menuId) + "\n");
			answer.append("Average for Menu # " + menuId + " " + (int)director.getAveragePerMenu(menuId) + "\n");
		}
		
		
        System.out.println(answer.toString());


    }
    
}
