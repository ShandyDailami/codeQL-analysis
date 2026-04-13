import java.sql.*;   // Import necessary Java packages from the sql library, e.g., DriverManager & Statement etc..   
public class java_46301_JDBCQueryHandler_A07 {    
       static final String url = "jdbc:mysql://localhost:3306/mydb";  /* Add your MySQL URL */     
       static final String username ="username_here";   // Your Username here         
       static final String password="password_here";    //Your Password Here       
     public static void main(String[] args) {        
           try (Connection con  = DriverManager.getConnection(url,username , password);           
                Statement stmt = con.createStatement())  {   /* Create a Connection and Prepared statement */             
                  String sqlQuery="SELECT * FROM Users WHERE id = " + args[0];    // SQL query here        
                   ResultSet rs =  stmt.executeQuery(sqlQuery);     // Execute the Query      
                    while (rs.next()) {   /* Fetch and print each row */            
                        System.out.println("Id : " + rs.getString('id')); 
                     }              
           } catch (SQLException e)    {         /* Catch any SQL Exception here*/       
                   // Handle your exception as needed         
               	System.err.format("SQL Exception occurred: %s",e);           	   	 		    									     	}                        
       }}  ;