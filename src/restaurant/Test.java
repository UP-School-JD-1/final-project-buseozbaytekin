package restaurant;

import java.util.LinkedList;
import java.util.Queue;
import restaurant.orderingItems.*;
import restaurant.factories.*;
import restaurant.person.*;
import restaurant.restaurantItems.*;

public class Test {

	Queue<Order> orderList = new LinkedList<Order>();

	public static void main(String[] args) {
		
		
		Management management = new Management();
		int customerCount = 9;
		int waiterCount = 5;
//			int chefCount = 1;
		
		Thread[] customersThread = new Thread[customerCount];
		for(int i = 1; i < customerCount; i++) {
			customersThread[i] = new Thread(new Customer (i, "Customer", management));
			customersThread[i].start();
			
		}
//		for(int i = 1; i < customerCount; i++) {
//			try {
//				customersThread[i].join();
//			}catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		}
		
		Thread[] waitersThread = new Thread[waiterCount];
		for(int i = 1; i < waiterCount; i++) {
			waitersThread[i] = new Thread(new Waiter (i, "Waiter", management));
			waitersThread[i].start();
		}
//		for(int i = 1; i < waiterCount; i++) {
//			try {
//				waitersThread[i].join();
//			}catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		}
		
		Chef chef = new Chef(1,"Chef", management);
		Thread t1 = new Thread(chef);
		t1.start();
		

	}

}
