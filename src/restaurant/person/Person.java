package restaurant.person;



public class Person {
	
	int id;
	String name;
	
	
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}


	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return   id + ", name:" + name;
	}



	
	
}
