package Restaurant;

public interface Director {
    /**
	 * Incorporates the provided menu into the database.
	 * 
	 * @param menuId
	 * @return false if menu already exists.
	 */
	public boolean addMenu(int menuId);

	/**
	 * Introduces an appetizer to the designated menu, 
	 * overwriting any existing entry if it already exists.
	 * 
	 * @param menuId
	 * @param itemNumber
	 * @param text           Appetizer text
	 * @param price         total price
	 */
	public void addAppetizer(int menuId, int itemNumber,
			String text, double price);

	/**
	 * Introduces a Main Dish to the designated menu, 
	 * replacing any existing entry if it already exists.
	 * 
	 * @param menuId
	 * @param itemNumber
	 * @param text           Main Dish text
	 * @param price         total price
	 */
	public void addMainDish(int menuId, int itemNumber,
			String text, double price);

	/**
	 * Introduces a Dessert to the designated menu, 
	 * replacing any existing entry if it already exists. 
	 * 
	 * @param menuId
	 * @param itemNumber
	 * @param text           Dessert text
	 * @param price        total price
	 */
	public void addDessert(int menuId, int itemNumber,
			String text, double price);

	/**
	 * Generates a string containing the following details for each item:<br />
	 * "Item: " followed by the item's description<br />
	 * "Price: " followed by the item's price<br />
	 * 
	 * @param menuId
	 * @return "Menu not found" if menu not found, otherwise the menu
	 */
	public String getMenu(int menuId);

	/**
	 * Incorporates the provided customer into the database, with names 
	 * following the format LastName, FirstName.
	 * 
	 * @param name
	 * @return false if customer already exists.
	 */
	public boolean addCustomer(String name);

	/**
	 * Enters the customer's paid amount for item into the database.
	 * 
	 * @param customerName
	 * @param menuId
	 * @param itemNumber
	 * @param paidAmount
	 */
	public void customerPaidAmount(String customerName, int menuId,
			int itemNumber, double paidAmount);

	/**
	 * Returns the price the customer paid for the designated menu.
	 * 
	 * @param customerName
	 * @param menuId
	 * @return amount
	 */
	public double getCustomerMenuPay(String customerName, int menuId);

	/**
	 * Produces a menu report for the designated menu. The report will contain 
	 * the following details for each menu item:<br />
	 * "Item #" {itemNumber} {amountPaid} " points out of " {totalAmountPossible}
	 * <br /> The report will conclude with the following information:<br />
	 * "Total Price: " {Total Price}
	 * 
	 * @param customerName
	 * @param menuId
	 * @return report
	 */
	public String getMenuReport(String customerName, int menuId);

	/**
	 * Calculates the average order amount for the customer by considering all menus.
	 * 
	 * @param customerName
	 * @return average amount
	 */
	public double getCustomerMenuAverage(String customerName);

	/**
	 * Provides a list displaying the average order amount for each customer. 
	 * The report includes the following details for each customer:<br />
	 * {customerName} {menuAverageAmount}<br />
	 * The names are presented in sorted order.
	 * 
	 * @return averages
	 */
	public String getEachCustomerAverage();

	/**
	 * Returns the maximum total amount (among all the customers) for the designated
	 * menu.
	 * 
	 * @param menuId
	 * @return maximum
	 */
	public double getMaxAmount(int menuId);

	/**
	 * Returns the minimum total amount (among all the customers) for the designated
	 * menu.
	 * 
	 * @param menuId
	 * @return minimum
	 */
	public double getMinAmount(int menuId);

	/**
	 * Returns the average Total Amount for the designated menu.
	 * 
	 * @param menuId
	 * @return average
	 */
	public double getAveragePerMenu(int menuId);

	/**
	 * It will serialize the Director object and save it to the designated file.
	 */
	public void DirectorToSave(Director director, String fileName);

	/**
	 * It will retrieve a Director object from the serialized data 
	 * located in the specified file.
	 */
	public Director DirectorToReplace(String fileName);
}
