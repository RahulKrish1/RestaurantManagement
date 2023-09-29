package Restaurant;

import java.io.*;
import java.util.ArrayList;

public class RestaurantDirector implements Director, Serializable {

    private ArrayList<Menu> database;
    
    public RestaurantDirector() {

        database = new ArrayList<Menu>();

    }
    
    @Override
    public boolean addMenu(int menuId) {
        Menu menu = new Menu(menuId);
		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).equals(menu)) {

				return false;

			}

		}

		database.add(menu);
		return true;
    }

    @Override
    public void addAppetizer(int menuId, int itemNumber, String text, double price) {
        
        Appetizer appetizer = new Appetizer(text, itemNumber, price);

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				database.get(i).addAnItem(appetizer);

			}

		}
    }

    @Override
    public void addMainDish(int menuId, int itemNumber, String text, double price) {
        MainDish mainDish = new MainDish(text, itemNumber, price);

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				database.get(i).addAnItem(mainDish);

			}

		}
    }

    @Override
    public void addDessert(int menuId, int itemNumber, String text, double price) {
        Dessert dessert = new Dessert(text, itemNumber, price);

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				database.get(i).addAnItem(dessert);

			}

		}
    }

    @Override
    public String getMenu(int menuId) {
        
        String menu = "";

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				for (int j = 0; j < database.get(i).getItems()
						.size(); j++) {

					if (database.get(i).getItems().get(j)
							.getClass() == Appetizer.class) {

						menu += "Item: " + ((Appetizer) database.get(i)
								.getItems().get(j)).getText() + "\n";
						menu += "Price: " + ((Appetizer) database.get(i)
								.getItems().get(j)).getPrice() + "\n";

					} else if (database.get(i).getItems().get(j)
							.getClass() == MainDish.class) {

						menu += "Item: "
								+ ((MainDish) database.get(i)
										.getItems().get(j)).getText()
								+ "\n";
						menu += "Price: "
								+ ((MainDish) database.get(i)
										.getItems().get(j)).getPrice()
								+ "\n";
					} else if (database.get(i).getItems().get(j)
							.getClass() == Dessert.class) {

						menu += "Item: " + ((Dessert) database.get(i)
								.getItems().get(j)).getText() + "\n";
						menu += "Price: " + ((Dessert) database.get(i)
								.getItems().get(j)).getPrice() + "\n";

					}

				}

			}

		}

		return menu;
    }

    @Override
    public boolean addCustomer(String name) {
        
        Customers customer = new Customers(name);

		int count = 0;

		for (int i = 0; i < database.size(); i++) {

			for (int j = 0; j < database.get(i).getCustomers().size(); j++) {

				if (!(((Customers) database.get(i).getCustomers().get(j))
						.getCustomerName().equals(name))) {

					count++;

				} else {

					count = 0;

				}

			}

			if (count != 0 || database.get(i).getCustomers().size() == 0) {

				database.get(i).addACustomer(name);

			}

			if (i == database.size() - 1 && count == 0) {

				return false;

			}

		}

		return true;
    }

    @Override
    public void customerPaidAmount(String customerName, int menuId, int itemNumber, double paidAmount) {
        addCustomer(customerName);

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				for (int j = 0; j < database.get(i).getCustomers().size(); j++) {

					if (((Customers) database.get(i).getCustomers().get(j))
							.getCustomerName().equals(customerName)) {

						((Customers) database.get(i).getCustomers().get(j))
								.addToAmount(itemNumber, paidAmount);

					}

				}

			}

		}
    }

    @Override
    public double getCustomerMenuPay(String customerName, int menuId) {
        
        double customerPay = 0.0;

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				for (int j = 0; j < database.get(i).getCustomers().size(); j++) {

					if (((Customers) database.get(i).getCustomers().get(j))
							.getCustomerName().equals(customerName)) {

						for (int k = 0; k < database.get(i).getItems()
								.size(); k++) {

							if (database.get(i).getItems().get(k)
									.getClass() == Appetizer.class) {

								if (((CustomersAmount) ((Customers) database.get(i)
										.getCustomers().get(j)).getAllAmounts()
										.get(k))
										.getAmountToPay()
										.equals(((Appetizer) database.get(i)
												.getItems().get(k))
												.getPrice())) {

									customerPay += ((Appetizer) database.get(i)
											.getItems().get(k)).getPrice();

								}

							} else if (database.get(i).getItems().get(k)
									.getClass() == MainDish.class) {

                                if (((CustomersAmount) ((Customers) database.get(i)
										.getCustomers().get(j)).getAllAmounts()
										.get(k))
										.getAmountToPay()
										.equals(((MainDish) database.get(i)
												.getItems().get(k))
												.getPrice())) {

									customerPay += ((MainDish) database.get(i)
											.getItems().get(k)).getPrice();

								}

							} else if (database.get(i).getItems().get(k)
									.getClass() == Dessert.class) {

                                if (((CustomersAmount) ((Customers) database.get(i)
										.getCustomers().get(j)).getAllAmounts()
										.get(k))
										.getAmountToPay()
										.equals(((Dessert) database.get(i)
												.getItems().get(k))
												.getPrice())) {

									customerPay += ((Dessert) database.get(i)
											.getItems().get(k)).getPrice();

								}

							}

							if (k == database.get(i).getItems().size()
									- 1) {

								j = database.get(i).getCustomers().size();

							}

						}

					}

				}

			}

		}

		return customerPay;
    }

    @Override
    public String getMenuReport(String customerName, int menuId) {
        String menuReport = "";
		
        double totalCustomerPay = 0.0;

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				for (int j = 0; j < database.get(i).getCustomers().size(); j++) {

					if (((Customers) database.get(i).getCustomers().get(j))
							.getCustomerName().equals(customerName)) {

						for (int k = 0; k < database.get(i).getItems()
								.size(); k++) {

							if (database.get(i).getItems().get(k)
									.getClass() == Appetizer.class) {

								totalCustomerPay += ((Appetizer) database.get(i)
										.getItems().get(k)).getPrice();

								if (((CustomersAmount) ((Customers) database.get(i)
										.getCustomers().get(j)).getAllAmounts()
										.get(k))
										.getAmountToPay()
										.equals(((Appetizer) database.get(i)
												.getItems().get(k))
												.getPrice())) {

									menuReport += "Item #:" + (k + 1)
											+ " "
											+ ((Appetizer) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ " paid out of "
											+ ((Appetizer) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ "\n";

								} else {

									menuReport += "Item #:" + (k + 1)
											+ " " + 0.0 + " paid out of "
											+ ((Appetizer) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ "\n";

								}

							} else if (database.get(i).getItems().get(k)
									.getClass() == MainDish.class) {

								totalCustomerPay += ((MainDish) database
										.get(i).getItems().get(k))
										.getPrice();

                                if (((CustomersAmount) ((Customers) database.get(i)
										.getCustomers().get(j)).getAllAmounts()
										.get(k))
										.getAmountToPay()
										.equals(((MainDish) database.get(i)
												.getItems().get(k))
												.getPrice())) {

									menuReport += "Item #:" + (k + 1)
											+ " "
											+ ((MainDish) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ " paid out of "
											+ ((MainDish) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ "\n";

								} else {

									menuReport += "Item #:" + (k + 1)
											+ " " + 0.0 + " paid out of "
											+ ((MainDish) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ "\n";

								}

							} else if (database.get(i).getItems().get(k)
									.getClass() == Dessert.class) {

								totalCustomerPay += ((Dessert) database.get(i)
										.getItems().get(k)).getPrice();

                                if (((CustomersAmount) ((Customers) database.get(i)
										.getCustomers().get(j)).getAllAmounts()
										.get(k))
										.getAmountToPay()
										.equals(((Dessert) database.get(i)
												.getItems().get(k))
												.getPrice())) {

									menuReport += "Item #:" + (k + 1)
											+ " "
											+ ((Dessert) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ " paid out of "
											+ ((Dessert) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ "\n";

								} else {

									menuReport += "Item #:" + (k + 1)
											+ " " + 0.0 + " paid out of "
											+ ((Dessert) database.get(i)
													.getItems().get(k))
													.getPrice()
											+ "\n";

								}

							}

							if (k == database.get(i).getItems().size()
									- 1) {

								j = database.get(i).getCustomers().size();

							}

						}

					}

				}

			}

		}

		menuReport += "Total Price: " + getCustomerMenuPay(customerName, menuId)
        + "\n" + "Total Price Possible: " + totalCustomerPay;
		
        return menuReport;
    }

    @Override
    public double getCustomerMenuAverage(String customerName) {
        
        double menuAverage = 0.0;

		for (int i = 0; i < database.size(); i++) {

			menuAverage += ((getCustomerMenuPay(customerName, database.get(i).getMenuId()))
					);

		}

		return (menuAverage / database.size());
    }

    @Override
    public String getEachCustomerAverage() {
        String customerAverage = "";

		for (int i = 0; i < database.get(0).getCustomersSorted().size(); i++) {

			customerAverage += ((Customers) database.get(0).getCustomersSorted()
					.get(i)).getCustomerName()
					+ " "
					+ getCustomerMenuAverage(((Customers) database.get(0)
							.getCustomersSorted().get(i)).getCustomerName())
					+ "\n";

		}

		return customerAverage;
    }

    @Override
    public double getMaxAmount(int menuId) {
        
        double highestAmount = 0.0;

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				for (int j = 0; j < database.get(i).getCustomers().size(); j++) {

					if (getCustomerMenuPay(
							((Customers) database.get(i).getCustomers().get(j))
									.getCustomerName(),
							menuId) > highestAmount) {

						highestAmount = getCustomerMenuPay(
								((Customers) database.get(i).getCustomers().get(j))
										.getCustomerName(),
								menuId);

					}

				}

			}

		}

		return highestAmount;
    }

    @Override
    public double getMinAmount(int menuId) {
        
        double lowestAmount = 0.0;
       
        for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				lowestAmount = database.get(i).getTotalPrice();

			}

		}

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				for (int j = 0; j < database.get(i).getCustomers().size(); j++) {

					if (getCustomerMenuPay(
							((Customers) database.get(i).getCustomers().get(j))
									.getCustomerName(),
							menuId) < lowestAmount) {

						lowestAmount = getCustomerMenuPay(
								((Customers) database.get(i).getCustomers().get(j))
										.getCustomerName(),
								menuId);

					}

				}

			}

		}

		return lowestAmount;
    }

    @Override
    public double getAveragePerMenu(int menuId) {
        
        double amountAdded = 0.0;

		double totalCustomers = 0;

		for (int i = 0; i < database.size(); i++) {

			if (database.get(i).getMenuId() == menuId) {

				totalCustomers = database.get(i).getCustomers().size();

				for (int j = 0; j < database.get(i).getCustomers().size(); j++) {

					amountAdded += getCustomerMenuPay(
							((Customers) database.get(i).getCustomers().get(j))
									.getCustomerName(),
							menuId);

				}

			}

		}

		return amountAdded / totalCustomers;
    }

    @Override
    public void DirectorToSave(Director director, String fileName) {
       
        try (ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(fileName))) {

			output.writeObject(director);
			System.out.println("Successfully Serialized");

		} catch (IOException e) {

			System.err.println("Failed to Serialize");
			e.printStackTrace();

		}
    }

    @Override
    public Director DirectorToReplace(String fileName) {
        
        Director director = null;

		try (ObjectInputStream output = new ObjectInputStream(
				new FileInputStream(fileName))) {

			director = (Director) output.readObject();
			System.out.println("Successfully Restored");

		} catch (ClassNotFoundException | IOException e) {

			System.err.println("Failed to Restore");
			e.printStackTrace();

		}

		return director;
    }
    
}
