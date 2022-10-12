package restaurant.orderingItems;

import java.util.concurrent.locks.Lock;

import restaurant.person.Customer;

public class Order {
	protected Drink drink=new Drink(null,null,0,0);;
	protected Food food=new Food(null,null,0,0);
	protected Food food1=new Food(null,null,0,0);
	 private Lock lock;
	 Customer customer;

	public Order(Drink drink, Food food, Food food1) {
		this.drink = drink;
		this.food = food;
		this.food1 = food1;
	}

	public Order(Food food, Food food1) {
		this.food = food;
		this.food1 = food1;
	}

	public Order(Drink drink, Food food) {
		this.drink = drink;
		this.food = food;
	}

	public Order(Drink drink) {
		this.drink = drink;
	}

	public Order(Food food) {
		this.food = food;
	}
	
	public  void takeOrder() { //müşteriden lock ı alacak 
		lock.lock();
		System.out.println(customer + " take customer's order: ");
		System.out.println();

	}

	public long prepTimeCounter() {
		long prepTime = food.preparationTime + food1.preparationTime + drink.preparationTime;
		return prepTime;
	}

	public long eatingTimeCounter() {
		long eatingTime = food.eatingTime + food1.eatingTime + drink.eatingTime;
		return eatingTime;
	}

	@Override
	public String toString() {
		return "drink: " + drink + ", food: " + food + ", food1: " + food1;
	}
}
