package restaurant.restaurantItems;

import restaurant.person.Customer;

public class Table {
	private int id;
	boolean isAvailable;
	Customer customer;
	
	
	public Table(int id) {
		this.id = id;
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Table " + getId() ;
	}
}
