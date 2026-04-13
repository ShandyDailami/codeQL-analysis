import java.sql.*;   // Import necessary libraries from Java database connectivity (JDBC) package   
public class java_51641_JDBCQueryHandler_A03 {    
       public static void main(String[] args){       
           String url = "jdbc:mysql://localhost/test";      // URL of MySQL server – you have to replace with your actual DB details.         
           String username="root";                  //Username for the database connection  
           String password="password";              //Password   
            try {       
                Connection con = DriverManager.getConnection(url,username,password);    
                 System.out.println("Connected to MySQL Server");     
                   Statement stmt  = con.createStatement(); 
                  ResultSet rs ;        
                    String query="SELECT * FROM Users WHERE Username =  "+"'user'" AND Password = PASSWORD('password')";    //Query with SQL injection attack using string formatting, consider avoiding it in a real application  
                   PreparedStatement pstmt  = con.prepareStatement(query); 
                      System.out.println("Executing query: ");     
                        try {        pstmt .executeUpdate();         }          catch (Exception ex)     {}            // Execute update operation and handle exceptions properly, this is just a demonstration    for real world applications always secure your data by using PreparedStatements with parameters  
                  rs = stmt.executeQuery(query);      System.out.println("Result set");       while (rs .next()) {        String name  = rs.getString ("name" );     //get the value from column in ResultSet           }          con.close();  finally block to ensure that resource gets closed properly, this is just a demonstration   
            } catch(SQLException e) {}         try{con.close()}catch (SQLException se){se.printStackTrace();}}     // Always close the connections after operations are done   for real world applications always use proper exception handling and SQL Exception Wrappers  Security should be implemented on server side as well to prevent unauthorized users from reading data or modifying it by using PreparedStatements