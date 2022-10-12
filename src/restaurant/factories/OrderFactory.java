package restaurant.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import restaurant.orderingItems.Drink;
import restaurant.orderingItems.Food;
import restaurant.orderingItems.Order;

public class OrderFactory {

	

	public static Food randomFood() {
		List<Food> foods = new ArrayList<>();
		foods.add(new Food("French fries", "fried potatoes", 2000, 1000));
		foods.add(new Food("Hamburger", "", 1000, 500));
		foods.add(new Food("Cheeseburger", "with cheese", 1000, 700));
		foods.add(new Food("Double-Cheeseburger", "double meatball with cheese", 1000, 500));
		foods.add(new Food("Pizza Margharita", "pizza with cheese and tomatoes", 1000, 1000));
		foods.add(new Food("Chicken Salad", "fresh vegtables and chicken", 1000, 900));
		foods.add(new Food("Cajun Chicken", "fried chicken", 800, 1000));

		Random rand = new Random();
        Food food = foods.get(rand.nextInt(foods.size()));
		return food;
	}
	
	public static Drink randomDrink() {
		List<Drink> drinks = new ArrayList<>();
		drinks.add(new Drink("CocaCola", "", 200, 500));
		drinks.add(new Drink("Wine", "", 200, 500));
		drinks.add(new Drink("Beer", "", 200, 500));
		drinks.add(new Drink("Soda", "", 200, 500));
		drinks.add(new Drink("Water", "", 200, 500));

		Random rand = new Random();
        Drink drink = drinks.get(rand.nextInt(drinks.size()));
		return drink;
	}
	
	public static Order randomOrder(int choosing) { //prep ve eat time lar eklenecek
		Random random = new Random();
		Food foodChoose = randomFood();
		Food foodChoose1 = randomFood();
		Drink drinkChoose = randomDrink();
		
		List<Order> orders=new ArrayList<>();
		orders.add(new Order(drinkChoose, foodChoose,foodChoose1));
		orders.add(new Order(foodChoose,foodChoose1));
		orders.add(new Order(drinkChoose, foodChoose));
		orders.add(new Order(drinkChoose));
		orders.add(new Order(foodChoose));
		
		Order order = orders.get(choosing);
		/*Order order =new Order();
		if (choosing == 0) {
			//orders.add(new Order(drinkChoose, foodChoose,foodChoose1));		
			Order order= new Order(drinkChoose, foodChoose,foodChoose1);

		} else if (choosing == 1) {
			//orders.add(new Order(foodChoose, foodChoose1));
			Order order= new Order(foodChoose,foodChoose1);

		} else if (choosing == 2) {
			//orders.add(new Order(drinkChoose, foodChoose));
			Order order= new Order(drinkChoose, foodChoose);

		} else if (choosing == 3) {
			//orders.add(new Order(foodChoose));
			Order order= new Order(foodChoose1);

		} else {
			//orders.add(new Order(drinkChoose));
			Order order= new Order(drinkChoose);
		}*/

	
		
		
		return order;//buraya return ne gelecek
		
	}
	
}
