package pkg;

public class StoreProduct {
	private String name, department, aisle, section;
	private int x, y;
	
	/* Temporary constructor to make testing easier. Remove once TSPTestDriver is no longer needed */
	public StoreProduct(String name, String department, String aisle, String section, int x, int y) {
		setName(name);
		setDepartment(department);
		setAisle(aisle);
		setSection(section);
		setX(x);
		setY(y);
	}
	
	public StoreProduct() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name != null) this.name = name;
		else this.name = "";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if(department != null) this.department = department;
		else this.department = "";
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		if(aisle != null) this.aisle = aisle;
		else this.aisle = "";
	}
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		if(section != null) this.section = section;
		else this.section = "";
	}

	/** Getter and setter for x and y coordinates */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/** Returns whether the product is or is not an endpoint */
	public boolean isEndpoint() {
		return (name == "Endpoint");
	}
}