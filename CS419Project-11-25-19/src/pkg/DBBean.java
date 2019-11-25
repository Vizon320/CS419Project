package pkg;

import java.sql.*;

public class DBBean {
	private Connection connection = null;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/javabook?useSSL=false";
	private String username = "scott";
	private String password = "tiger";

	
	/** Initialize database connection */
	public void initializeJdbc() {
		try {
			System.out.println("Driver is " + driver);
			Class.forName(driver);
	
			// Connect to the sample database
			connection = DriverManager.getConnection(url, username, password);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/** Get tables in the database */
	public String[] getTables() {
		String[] tables = null;
		
		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet rsTables = dbMetaData.getTables(null, null, null, new String[] {"TABLE"});
			
			int size = 0;
			while (rsTables.next()) size++;
			
			rsTables = dbMetaData.getTables(null, null, null, new String[] {"TABLE"});
			
			tables = new String[size];
			
			int i = 0;
			
			// Parse catalog name (schema) from MySQL url
			int beginIndex = url.lastIndexOf('/')+1;
			int endIndex = url.indexOf('?');
			String schema = url.substring(beginIndex, endIndex);
			System.out.println(schema);
			
			while (rsTables.next()) {
				System.out.println(rsTables.getString("TABLE_CAT"));
				if (schema.equals(rsTables.getString("TABLE_CAT")))
					tables[i++] = rsTables.getString("TABLE_NAME");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
		return tables;
	}
	
	/** Return connection property */
	public Connection getConnection() {
		return connection;
	}
	
	public void setUsername(String newUsername) {
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
	}
	
	public void setDriver(String newDriver) {
		driver = newDriver;
	}
	
	public String getDriver() {
		return driver;
	}
	
	public void setUrl(String newUrl) {
		url = newUrl;
	}
	
	public String getUrl() {
		return url;
	}
}