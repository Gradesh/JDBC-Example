import java.sql.*;
import java.sql.SQLData;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.SQLData;


public class usingSSMS {

	public static void main(String[] args)throws Exception 
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 String connectionUrl = "jdbc:sqlserver://MAVCHN0522463:1433;databaseName=sample1;integratedSecurity=true;Authentication=Windows Authentication;";
		 
		 MysqlDataSource ds = new MysqlDataSource();  
		// ds.setUser("MyUserName");  
		// ds.setPassword("*****");  
		 ds.setServerName("MAVCHN0522463");  
		 ds.setPortNumber(1433);
		 ds.setDatabaseName("Sample1");  
		 Connection con = ds.getConnection(); 
		 try ( Statement stmt = con.createStatement();) {
	            String SQL = "SELECT * FROM persons";
	            ResultSet rs = stmt.executeQuery(SQL);

	            // Iterate through the data in the result set and display it.
	            while (rs.next()) {
	                System.out.println(rs.getString("LastName") + " " + rs.getString("FirstName"));
	                System.out.println(rs.getString("Address")+""+rs.getString("City"));
	            }
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	            e.printStackTrace();
	        }


	}

}
