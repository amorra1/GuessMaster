package PersonAndDate;

public class Entity {
	private String name;
	private Date born; 
	
	//no argument constructor
	public Entity() {
		name = "";
		born = null;
	}
	
	//argument constructor
	public Entity(String name, Date born) {
		this.name = name;
		this.born = born;
	}
	
	//copy constructor method
	public Entity(Entity other) {
		this.name = other.name;
		this.born = new Date(other.born);
	}
	
	//accessor methods
	//one for name and one for date born
	public String getName() {
		return name;
	}
	
	public Date born() {
		return new Date(born);
	}
	
	//mutator methods
	//one for name and one for date born
	public void setName(String newName) {
		name = newName;
	}
	
	public void setDate(Date newBorn) {
		born = newBorn;
	}
	
	//toString method
	//returns entity as a string
	public String toString(Entity entity) {
		return entity.name + ", born on " + entity.born; 
	}
	
	//equals method
	//followed textbook example pg. 204
	public boolean equals(Entity otherEntity) {
		return ((this.name.equals(otherEntity.name) && (this.born).equals(otherEntity.born)));
	}
	
}


