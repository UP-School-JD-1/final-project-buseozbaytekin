package restaurant.person;

import restaurant.orderingItems.Order;
import restaurant.restaurantItems.Management;

public class Chef extends Worker  implements Runnable{
	
	//Order order;
	boolean isOrderDone;
	Management management;
	Customer customer;
	Order order;

	public Chef(int id, String name, Management management) {
		super(id, name);
		this.management = management;
		
	}
	
	public synchronized void preperingOrder() { //garsondan lockı alacak ve hazırlamaya başlayacak. hazırlanma süresi kadar uyuyacak
		order = management.preparingOrder.element();
		System.out.println("Chef is prepearing order "+order.toString()+" .");
		System.out.println();
		management.preparingOrder.poll();
		
		try {
			Thread.sleep(order.prepTimeCounter());//notşfy waşt eklenecek bukadar uyur
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void completedOrder() { //yemeğin hazır olduğunu söyleyecek. garsona lockı teslim edecek ve müsaitim diyecek
		Order order = management.preparingOrder.poll();
		isOrderDone = true;
		System.out.println("Chef completed order and aviable now.");
		System.out.println();
		management.preparedOrder.add(order);
		//Waiter.deliverOrder();
		
	}

	@Override
	public void run() {
		while(!management.preparingOrder.isEmpty()) {
			synchronized (this) {
				preperingOrder();
				completedOrder();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
	}

}
