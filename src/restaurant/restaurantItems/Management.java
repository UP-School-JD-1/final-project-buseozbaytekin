package restaurant.restaurantItems;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import restaurant.orderingItems.*;
import restaurant.person.Customer;

public class Management {
	
	public int table = 4;
	
	public Queue<Order> preparingOrder = new LinkedList<>();
	public Queue<Order> preparedOrder = new LinkedList<>();
	
	
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table += table ;
	}

	


}
