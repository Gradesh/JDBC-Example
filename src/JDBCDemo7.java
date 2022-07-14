import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.*;

public class JDBCDemo7 {

	public static void main(String[] args)throws Exception
	{
		Scanner sc= new Scanner(System.in);
		Connection con= null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/universe","root","Monaleesa123@");
		Statement st= con.createStatement();
		
		System.out.println("Select Numbers Accordingly:: \n 1.) Show data\n 2.) Insert Data");
		int ch=sc.nextInt();
		
		switch (ch)
		{
		case 1:
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			List<Country> country= new ArrayList<Country>();
			try 
			{
				
				//Show data code
				
				ResultSet rs= st.executeQuery("select * from Country");
				while (rs.next())
				{
					Country cntry= new Country();
					cntry.setC_Code(rs.getString("C_Code"));
					cntry.setC_Name(rs.getNString("C_Name"));
					cntry.setC_Coninent(rs.getString("C_Continent"));
					cntry.setC_Region(rs.getString("C_Region"));
					cntry.setC_LocalName(rs.getString("C_Localname"));
					cntry.setLifeExpectency(rs.getFloat("lifeExpectency"));
					
					country.add(cntry);
				}
				for (Country cntry: country)
				{
					System.out.println(cntry.getC_Code()+"||"+cntry.getC_Name()+"||"+cntry.getC_Coninent()
					+"||"+cntry.getC_LocalName()+"||"+cntry.getC_Region()+"||"+cntry.getLifeExpectency()
							);
				}
				
			
				
				con.close();			
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
			}	
		}
			break;
			
		case 2:
		{
			//Insert Code
			Country cntry= new Country();

	        System.out.println("Enter lifeExpectency");
			float lifeExpectency=sc.nextFloat();
			sc.nextLine();
			System.out.println("Enter C_Code");
			String C_Code=sc.nextLine();
			System.out.println("Enter C_Name");
			String C_Name=sc.nextLine();
			System.out.println("Enter C_Continent");
			String C_Continent=sc.nextLine();
			System.out.println("Enter C_Region");
			String C_Region=sc.nextLine();
			System.out.println("Enter C_Localname");
			String C_Localname=sc.nextLine();
			
			Statement stmt=con.createStatement();


        String query1 = "INSERT INTO Country " + "VALUES ('" + lifeExpectency + "','" + C_Code + "','" + C_Name + "','"+C_Continent+"','"+C_Region+"','"+C_Localname+"')";
        

        stmt.executeUpdate(query1);
        System.out.println("Query Executed!! Data added successfully");
			
			
		}
			
			break;
		
		
		default:
			System.out.println("Incorrect Selection !!!! please Re-Run the Program");
			break;
		
		}		

	}

}
