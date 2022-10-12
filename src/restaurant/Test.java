package restaurant;

import java.util.LinkedList;
import java.util.Queue;
import restaurant.orderingItems.*;
import restaurant.factories.*;
import restaurant.person.*;
import restaurant.restaurantItems.*;

public class Test {

	public static void main(String[] args) {
		
		//Creating thread array. initiliaze threads name and started.
		Management management = new Management();
		int customerCount = 9;
		int waiterCount = 5;
		
		Thread[] customersThread = new Thread[customerCount];
		for(int i = 1; i < customerCount; i++) {
			customersThread[i] = new Thread(new Customer (i, "Customer", management));
			customersThread[i].start();
			
		}
		
		Thread[] waitersThread = new Thread[waiterCount];
		for(int i = 1; i < waiterCount; i++) {
			waitersThread[i] = new Thread(new Waiter (i, "Waiter", management));
			waitersThread[i].start();
		}
		
		Chef chef = new Chef(1,"Chef", management);
		Thread t1 = new Thread(chef);
		t1.start();
		

	}

}
