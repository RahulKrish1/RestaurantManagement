package Restaurant;

import java.io.Serializable;

public class CustomersAmount<T> implements Serializable {

	private int itemNumber;
	private T amountToPay;

	public CustomersAmount(int itemNumber, T amountToPay) {

		this.itemNumber = itemNumber;
		this.amountToPay = amountToPay;

	}

	public T getAmountToPay() {

		return this.amountToPay;

	}

}
