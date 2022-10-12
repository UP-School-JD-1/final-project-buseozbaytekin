package restaurant.person;

import restaurant.orderingItems.Order;
import restaurant.restaurantItems.Management;

public class Chef extends Worker  implements Runnable{

	boolean isOrderDone;
	Management management;
	Customer customer;
	Order order;

	public Chef(int id, String name, Management management) {
		super(id, name);
		this.management = management;
	}
	//Chef prepare order from preperingOrder queue and sleep prep time
	public synchronized void preperingOrder() {
		order = management.preparingOrder.element();
		System.out.println("Chef is prepearing order "+order.toString()+" .");
		System.out.println();
		management.preparingOrder.poll();
		try {
			Thread.sleep(order.prepTimeCounter());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Chef remove the completed order from preparingOrder queue and add preparedOrder queue
	public synchronized void completedOrder() { 
		Order order = management.preparingOrder.poll();
		isOrderDone = true;
		System.out.println("Chef completed order and aviable now.");
		System.out.println();
		management.preparedOrder.add(order);
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
