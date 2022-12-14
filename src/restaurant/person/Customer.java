package restaurant.person;

import java.util.List;
import java.util.Random;

import restaurant.factories.OrderFactory;
import restaurant.orderingItems.*;
import restaurant.restaurantItems.Management;
import restaurant.restaurantItems.Table;

public class Customer extends Person implements Runnable {

	boolean isOrdered;
	boolean isEaten;
	Management management;
	Order order;
	Table table;

	boolean isEntered = true;
	int controller = 0;
	boolean isLeave = false;

	public Customer(int id, String name, Management management) {
		super(id, name);
		this.management = management;
	}
//Customer check to available table and randomly decide waiting or go
	public void isAvailable() {
		if (management.getTable() > 0) {
			management.setTable(-1);
			isEntered = true;
		} else {
			if (controller == 0) {
				Random random = new Random();
				boolean isWait = random.nextBoolean();
				if (isWait) {
					waitCustomer();
				} else {
					go();
				}

			}

		}
	}

	public void waitCustomer() {
		System.out.println("Capacity is full but " + getName() + " " + getId() + " is waiting for available table.");
		isEntered = false;
		controller = 1; // bu nedir
	}

	public void go() {
		System.out.println("Capacity is full and " + getName() + " " + getId() + " is not have enough time.");
		isEntered = false;
		controller = 1; // bu nedir
	}

	public void entered() {
		System.out.println(this + " is in the restaurant.");
		System.out.println();

	}

	public void chooseTable() {
		System.out.println(getName() + " " + getId() + " is sitting table ");

	}
//Customer choose random order with OrderFactory's methods and add preparingOrder queue
	public synchronized Order chooseOrder() {
		this.order = OrderFactory.randomOrderChoose();
		System.out.println(getName() + " " + getId() + "'s order: " + this.order + ". Prep time: " + this.order.prepTimeCounter());
		System.out.println();
		management.preparingOrder.add(this.order);
		isOrdered = true;
		return this.order;
	}
	//Customer eat order
	public void eatOrder() {
		System.out.println(getName() + " " + getId() + " is eating " + this.order + ". Eating time: " + this.order.eatingTimeCounter());
		System.out.println();
		isEaten = true;
	}
	//Customer leave
	public void leave() {
		if (isEaten == true) {
			System.out.println(getName() + " " + getId() + " left.");
			System.out.println();
		}
		management.setTable(1);
		isLeave = true;
	}

	@Override
	public String toString() {
		return "Customer " + id ;
	}

	@Override
	public void run() {
		while (!isLeave) {
			isAvailable();
			synchronized (this) {
				if (isEntered) {
					entered();
					chooseTable();
					chooseOrder();
					eatOrder();
					leave();
				}
			}
		}

	}

}
