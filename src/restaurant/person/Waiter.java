package restaurant.person;

import restaurant.orderingItems.Order;
import restaurant.restaurantItems.Management;

public class Waiter extends Worker  implements Runnable{
	boolean takenOrder = false;
	Order order;
	Management management;
	Customer customer;
	
	boolean availableWaiter;
	
	public Waiter(int id, String name,Management management) {
		super(id, name);
		this.management = management;
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void takeOrder() { //müşteriden lock ı alacak 
		System.out.println(this + " take customer's order ");
		System.out.println();
		management.preparingOrder.element();

	}
	
	public synchronized void callChef() { // müşteriden aldığı lockı chef e verecek
		order = management.preparingOrder.element();
		System.out.println(this + " passed the order " +order.toString() +" to the chef.");
		System.out.println();
		//chef.preperingOrder();//düşün
		takenOrder = true;
		waitForOrder();

	}
	
	public void waitForOrder() { //yemek hazırlanırken beklemesini sağlayan method
		System.out.println(this + " waiting for the order ");
		System.out.println();
	}
	
	public synchronized void deliverOrder(Customer customer) { //lockı müşteriye teslim edecek müşteri yiyip gidecek
		System.out.println("Waiter: bone apetite! -delivered customer 's " + customer.getName() +" order: ");
		System.out.println();

		availableWaiter = true;
	}
	
	
	@Override
	public String toString() {
		return "Waiter " + id;
	}

	@Override
	public void run() {
		takeOrder();
		callChef();
		waitForOrder();
//		deliverOrder(null);
		
		// TODO Auto-generated method stub
		
	}

}
