import java.sql.*;
import java.util.*;
import java.sql.*;
import javax.sql.DataSource;
import java.sql.Types;

public class JDBC 
{

	public static void main(String[] args) throws Exception
	{Scanner sc= new Scanner(System.in);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sample1","root","Monaleesa123@");
		Statement st= con.createStatement();
		
		System.out.println("Select Number for \n 1. Insert \n 2. Show Data");
		int ch= sc.nextInt();
		
		switch(ch)
		{
			case 1:
			{
				//insert code
				try
				{ 
					
			        System.out.println("Enter PersonID");
					int PersonID=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Last Name");
					String LName=sc.nextLine();
					System.out.println("Enter First Name");
					String FName=sc.nextLine();
					System.out.println("Enter Address");
					String Add=sc.nextLine();
					System.out.println("Enter City");
					String City=sc.nextLine();
					Statement stmt=con.createStatement();


	            String query1 = "INSERT INTO Persons " + "VALUES ('" + PersonID + "','" + FName + "','" + LName + "','"+Add+"','"+City+"')";
	            

	            stmt.executeUpdate(query1);
	            System.out.println("Query Executed!! Data added successfully");
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
				
				
				
			}
				break;
				
			case 2:
			{
				try 
				{
					
					ResultSet rs= st.executeQuery("select * from persons");
					while (rs.next())
					{
						System.out.println(rs.getString(1)+"||"+rs.getString(2)+"||"+rs.getString(3)+"||"+rs.getString(4)+"||"+rs.getString(5));
					}
					
				}
				catch (Exception e)
				{
					System.out.println("Exception Raised!!!");
					
				}
			
				
				
			}
			break;
			
			default:
				System.out.println("Incorrect Option Entered!!!!");
				break;
			
		}
		//Show data
		
		st.close();
		con.close();
		}		
	

	}	
	

