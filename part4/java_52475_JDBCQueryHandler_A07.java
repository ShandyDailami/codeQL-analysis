import java.sql.*;

public class java_52475_JDBCQueryHandler_A07 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{    	  
        String url = "jdbc:mysql://localhost/test"; // Change this to your actual database URL        
				String username="username_here", password="password_here"; 	// Replace with real values (leave them blank if not used)            		
				      													   	    	 	       	   	     
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL driver          			        
                     System.out.println ("MySQL JDBC Driver Registered Successfully.");            		 				      } catch (ClassNotFoundException e) {    	                                                       throw new ExceptionInInitializerError(e);   }}          private static Connection connection;              public void connectToDatabase() throws SQLException, ClassNotFoundException{       try {          
                  if ((connection = DriverManager.getConnection(url , username , password)) != null )  System.out.println ("Connected Successfully.");      } catch (SQLException | ClassNotFoundException e) {          throw new ExceptionInInitializerError("Failed to connect: " +e);}}          
                public void executeQuery() throws SQLException, ClassNotFoundException{             try(Statement stmt = connection .createStatement())            ResultSet rs = 	stmt.executeQuery ("SELECT * FROM myTable")) {      while (rs.next()) System.out.println("Data: " + rs.getString(1));} catch (SQLException | ClassNotFoundException e)   
                throw new ExceptionInInitializerError("Failed to execute query"+e);   } public void closeConnection() throws SQLException,ClassNotFoundException {      try{connection .close(); System.out.println ("Closed Connection Successfully."); 	} catch (SQLException | ClassNotFoundException e)   
                throw new ExceptionInInitializerError("Failed to disconnect: " +e);}} }        if(__class__=='java')new AuthFailure().connectToDatabase() ; // Call the method here, for example. }; }}