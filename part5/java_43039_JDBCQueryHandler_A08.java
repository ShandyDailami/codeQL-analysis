import java.sql.*;   // Import necessary classes to use database functions 
// JDBCDriver, Connection and Statement objects are available from this package   
    
public class java_43039_JDBCQueryHandler_A08 {     
       public static void main(String[] args) throws SQLException{       
           String url = "jdbc:mysql://localhost/test";   //replace with your database details 
           String userName ="root";                     // replace root if it's different in real case.   
           String password="password1234567890..?";     // provide a secure one, for example from environment variable or some other secured storage  
           
          Connection connection  = DriverManager.getConnection(url , userName  , password);//Establish the database connectivity   
           String query = "SELECT * FROM employees WHERE id < ? AND salary > ?"; //use parameterized queries, preventing SQL Injection in real world applications by using PreparedStatements or Parameterized Queries  
           
          PreparedStatement preparedStmt  = connection.prepareStatement(query);   
          
         /* Here we are setting parameters to the query which prevents sql injection attacks */    
             int id = 10;  //Example value that might come from user input, not hard coded here      
              double salary=5000 ;//example values for real world application  
               preparedStmt.setInt(1 ,id);   
                preparedStmt.setDouble(2,salary );    
           // Executing the query and getting a result set  from database     
            ResultSet rs = preparedStmt.executeQuery();        
             while (rs.next()) {      		       		// Process each row of data returned   }             	 	     	   	        });   	} }}                  */