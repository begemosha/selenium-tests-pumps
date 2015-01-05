package begemosha.selenium.pumps.model;

public class Product {
	private int id;
	private String name;
	private boolean isAvailable;
	
	public int getId() {
		return id;
	}
	public Product setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public Product setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		return this;
	}
}
