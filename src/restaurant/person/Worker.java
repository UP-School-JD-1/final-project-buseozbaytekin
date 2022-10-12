package restaurant.person;

public class Worker extends Person{

	public Worker(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  getId() + " " + getName();
	}

	

}
