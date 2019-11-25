package pkg;

import java.sql.*;
import java.util.*;

public class StoreDao {
	private static Connection connection = null;
	private static String schema = "stores";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	//private String username = "scott";
	//private String password = "tiger";
	
	// Maybe make methods for getting products with a specific aisle, department, or name?
	// To make the query method necessary in fewer cases
	
	/** Initialize database connection, run first */
	public static void initializeJdbc() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(getUrl(), "root", "sesame");
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
	}
	
	public static List<StoreProduct> getAllProductsFromTable(String tableName) {
		List<StoreProduct> list = new ArrayList<StoreProduct>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from " + tableName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				StoreProduct s = new StoreProduct();
				s.setName(rs.getString("prodName"));
				s.setDepartment(rs.getString("department"));
				s.setAisle(rs.getString("aisleNo"));
				s.setSection(rs.getString("section"));
				s.setX(rs.getInt("xCoord"));
				s.setY(rs.getInt("yCoord"));
				list.add(s);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}
	
	public static List<StoreProduct> getProductsByQuery(String query) {
		List<StoreProduct> list = new ArrayList<StoreProduct>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StoreProduct s = new StoreProduct();
				s.setName(rs.getString("prodName"));
				s.setDepartment(rs.getString("department"));
				s.setAisle(rs.getString("aisleNo"));
				s.setSection(rs.getString("section"));
				s.setX(rs.getInt("xCoord"));
				s.setY(rs.getInt("yCoord"));
				list.add(s);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	/** Return connection property */
	/*public Connection getConnection() {
		return connection;
	}*/
	
	/*public void setUsername(String newUsername) {
		username = newUsername;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String newPassword) {
		password = newPassword;
	}
	
	public String getPassword() {
		return password;
	}*/
	
	/*public void setDriver(String newDriver) {
		driver = newDriver;
	}*/
	
	/*public static String getDriver() {
		return "com.mysql.cj.jdbc.Driver";
	}*/
	
	public static void setSchema(String newSchema) {
		schema = newSchema;
	}
	
	public static String getUrl() {
		return "jdbc:mysql://localhost/" + schema + "?useSSL=false";
	}
}