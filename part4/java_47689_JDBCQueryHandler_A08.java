import java.sql.*;  // import the required Java packages for JDBC SQL operations  
    
public class java_47689_JDBCQueryHandler_A08 {   
       public static void main(String[] args) throws Exception{     
           Connection connection = null;       
            try{         
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver        
            	connection= DriverManager.getConnection ("dburl", "username","password" );  // get a database connection             
		     Statement stmt = connection.createStatement();           
                    ResultSet rs =  stmt.executeQuery("SELECT * FROM employees");   	// execute SQL query         			  	            	   	}      finally {           if (connection != null)         try{                // close the database resources              ConnectionManager( ).closeConnection  ( connection ); } catch (SQLException e){e.printStackTrace();}        }}