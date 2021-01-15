
public class Inventory {
    protected int id;
    protected String name;
    protected int rating;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Inventory(int id, String name, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	public Inventory() {
		super();
	}
	public Inventory(String name, int rating) {
		super();
		this.name = name;
		this.rating = rating;
	}
}