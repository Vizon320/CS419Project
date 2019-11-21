package pkg;

import java.util.*;

public class StoreBean {
	private String storeName;
	private String tableName;
	// Would this be used or need to be used?
	private List<StoreProduct> products;
	
	public String getName() {
		return storeName;
	}

	public void setName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getTable() {
		return tableName;
	}

	public void setTable(String tableName) {
		this.tableName = tableName;
	}
	
	public List<StoreProduct> getProducts() {
		return products;
	}
	
	public void setProducts(List<StoreProduct> products) {
		this.products = products;
	}
	
	
	
}