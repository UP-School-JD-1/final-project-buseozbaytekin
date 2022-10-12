package restaurant.factories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import restaurant.restaurantItems.Table;
import restaurant.orderingItems.Order;
import restaurant.person.Chef;
import restaurant.person.Waiter;

public class RestaurantItemFactory {
	public static Queue <Order> prepearingFoods = new LinkedList<> ();
	public static Queue <Order> prepearedFoods = new LinkedList<> ();

//	public static List<Table> tableList(int i) {
//		List<Table> tables = new ArrayList<>();
//		
//			tables.add(new Table(1));
//		
//			tables.add(new Table(2));
//	
//			tables.add(new Table(3));
//		
//			tables.add(new Table(4));
//		
//		
//		return tables;
//	}
//	
//
//
//	public static List<Waiter> waiterList() {
//		List<Waiter> waiters = new ArrayList<>();
//		waiters.add(new Waiter(1, "Ahmet"));
//		waiters.add(new Waiter(2, "Mehmet"));
//		waiters.add(new Waiter(3, "Sevda"));
//		waiters.add(new Waiter(4, "Elif"));
//		// waiters.add(new Waiter(5,"")); //bunu çıkarıp tekrar çalıştır
//		return waiters;
//	}
//
//	public static List<Chef> chefList() {
//		List<Chef> chefs = new ArrayList<>();
//		chefs.add(new Chef(1, "Merve"));
//		chefs.add(new Chef(2, "Atakan"));
//		return chefs;
//	}

}
