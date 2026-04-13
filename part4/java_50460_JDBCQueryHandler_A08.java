import java.sql.*;
public class java_50460_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{       
            String connectionURL = "jdbc://localhost/testdb";      // replace with your actual database URL      
            
	    Connection conn=null;               //create a variable for the DBConnection        
	   try {                    
	        Class.forName("com.mysql.cj.jdbc.Driver");  /*Or wherever you have put JDBC driver */    
		      System.out.println("Successfully Connected with MySQL!");    // Prints Successful Connection Message on console         
	           conn = DriverManager.getConnection(connectionURL, "user", "password1234");   /*Your username and password*/ 
        } catch (Exception e) {                   System.out.println("Error in loading the driver!");     //Prints Error message if failed to load JDBC Drivers   			e.printStackTrace();       return;     	}               	   
               Statement stmt=conn.createStatement( );                  /* create a variable for SQL statements */  				  try {                    String sql = "INSERT INTO EMPLOYEE (NAME, AGE) VALUES ('John', '23')"; //SQL query to insert data into table                    	stmt.executeUpdate(sql);         System.out.println("Records inserted successfully");     } catch (Exception e){System.out.print("Error occurred in database operation!"+e );}   finally {               conn.close();            }}