package Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Menu<T> extends RestaurantDirector {

	private int menuId;
	private ArrayList<T> items;
	private ArrayList<Customers> customers;

	public Menu(int menuId) {

		this.menuId = menuId;
		items = new ArrayList<T>();
		customers = new ArrayList<Customers>();

	}

	public int getMenuId() {

		return this.menuId;

	}

	public ArrayList<T> getItems() {

		return items;

	}

	public ArrayList<Customers> getCustomers() {

		return customers;

	}

	public ArrayList<Customers> getCustomersSorted() {

		Comparator<Customers> nameComparator = (c1, c2) -> c1.getCustomerName()
				.compareTo(c2.getCustomerName());

		customers.sort(nameComparator);

		return customers;

	}

	public void addAnItem(T item) {

		items.add(item);

	}

	public void addACustomer(String customerName) {

		Customers customer = new Customers(customerName);
		customers.add(customer);

	}

	public double getTotalPrice() {

		double total = 0.0;

		for (int i = 0; i < items.size(); i++) {

			if (items.get(i).getClass() == Appetizer.class) {

				total += ((Appetizer) items.get(i)).getPrice();

			} else if (items.get(i).getClass() == MainDish.class) {

				total += ((MainDish) items.get(i)).getPrice();

			} else if (items.get(i).getClass() == Dessert.class) {

				total += ((Dessert) items.get(i)).getPrice();

			}

		}

		return total;

	}

}
