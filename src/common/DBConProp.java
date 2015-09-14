package common;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	/**
	 * @author Sajal
	 *
	 */

	public class DBConProp 
	{
/*		PropertyReader pr = new PropertyReader();
		
		String DriverName = "";
		String DBurl = "";
		String UserName = "";
		String Pwd = "";
		String sql = "";
		Connection con;
		Statement st;
		ResultSet rs;
*/		
		PropertyReader pr = new PropertyReader();
		String DriverName;
		String DBurl;
		String UserName;
		String Pwd;
		String sql;
		Connection con;
		Statement st;
		ResultSet rs;
		
		DBConProp()
		{
			OpenConnection(DBurl,UserName,Pwd);
			executequery(sql);
			TraverseData();
			CloseConnection();
		}
		
		public String getProperties(String key)
		{	
			System.out.println("Loading Properti file");
			pr.loadProperty("D:\\Sajal\\Workspace\\packageTest\\src\\packageTest\\DB.Properties");
			System.out.println("Property Loaded Successfully");
			return pr.getProperty(key);
			
			 		
	   } 

		/*DriverName = pr.getProperties("DriverName");
		 DBurl = pr.getProperties("DBurl");
		 UserName = pr.getProperties("UserName");
		 Pwd = pr.getProperties("Pwd");
		 sql = pr.getProperties("sql");*/

		
			
		public void OpenConnection(String url,String user,String password)
		{
			try
			{
				System.out.println("Opening DB connection...");	
			Class.forName(getProperties("DriverName"));
			con = DriverManager.getConnection(getProperties("DBurl").trim(), getProperties("UserName").trim(), getProperties("Pwd").trim());
			st = con.createStatement();
			System.out.println("Created DB Connection....");
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		} 

		public void executequery(String query)
		{
			try {
				rs = st.executeQuery(getProperties("sql").trim());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void TraverseData()
		{
			try 
			{
			while(rs.next())
			{
			//Retrieve by column name
			int id;
			id = rs.getInt("employees_id");
			String fname = rs.getString("first_name");
			String last = rs.getString("last_name");
			//Display values
			System.out.print("ID: " + id);
			System.out.print(", First: " + fname);
			System.out.println(", Last: " + last);
			}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		public void CloseConnection()
		{
			try {
				con.close();
				System.out.println("DB Connection Closed Successfully....");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


