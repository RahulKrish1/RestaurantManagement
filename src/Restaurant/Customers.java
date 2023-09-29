package Restaurant;

import java.io.Serializable;
import java.util.ArrayList;

public class Customers<T> implements Serializable {

	private String customerName;
	private ArrayList<CustomersAmount> paidAmount;

	public Customers(String customerName) {

		this.customerName = customerName;
		paidAmount = new ArrayList<CustomersAmount>();

	}

	public String getCustomerName() {

		return this.customerName;

	}

	public ArrayList<CustomersAmount> getAllAmounts() {

		return paidAmount;

	}

	public void addToAmount(int itemNumber, T amountToPay) {

		CustomersAmount ca = new CustomersAmount(itemNumber, amountToPay);
		paidAmount.add(ca);

	}

}
