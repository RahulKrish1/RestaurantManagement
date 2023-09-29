package Restaurant;

import java.io.Serializable;

public class Dessert implements Serializable {

	private String text;
	private int itemNumber;
	private double price;

	public Dessert(String text, int itemNumber, double price) {

		this.text = text;
		this.itemNumber = itemNumber;
		this.price = price;

	}

	public String getText() {

		return this.text;

	}

	public double getPrice() {

		return this.price;

	}

    public double getItemNumber() {

        return this.itemNumber;

    }

}
