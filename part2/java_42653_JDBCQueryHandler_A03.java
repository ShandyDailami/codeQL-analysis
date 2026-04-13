import java.sql.*;  // Import necessary Java libraries like JDBC and PreparedStatement  
public class java_42653_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/test";     // Provide your database URL here.      
         Connection con; 
          Class.forName("com.mysql.cj.jdbc.Driver");    // Load MySQL JDBC Driver for connections  
           System.out.println("\nConnecting to the Database...");     
            try (Connection connection = new ConnectionPool().getConnection(url, "username", "password")) {  /*Use database pool here*/    		      	        	        con=connection;    // Assign DB Connect object  			         	  System.out .println("Connected!");       										}
            catch (Exception e)     	   							              	{e.printStackTrace();}                    }                      if(con != null){                   try {                           PreparedStatement pstmt = con.prepareStatement ("INSERT INTO Persons VALUES (? , ? )");   for(int i = 0;i<10 ;+++, ++)           
                // Set values to the statement parameters  and execute it                        	                       			pstmt .setInt (2 + "value" + 3);                            pstmt.executeUpdate();          } catch { e ->println ("Error in inserting records into DB");     }}                    });