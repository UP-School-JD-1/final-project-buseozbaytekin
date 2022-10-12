package restaurant.orderingItems;

public class Menu {
	
	String name;
	String description;
	protected long preparationTime ;
	protected long eatingTime;
	
	public Menu(String name, String description, long preparationTime, long eatingTime) {
		super();
		this.name = name;
		this.description = description;
		this.preparationTime = preparationTime;
		this.eatingTime = eatingTime;
	}

	public long getPreparationTime() {
		return preparationTime;
	}

	public long getEatingTime() {
		return eatingTime;
	}

	@Override
	public String toString() {
		return name;
	}
	

}
