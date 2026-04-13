import java.sql.*;  // Importing necessary classes for JDBC (Java Database Connectivity) operations
  
public class java_51445_JDBCQueryHandler_A01 {     
    public static void main(String[] args){    
        String url = "jdbc:mysql://localhost/test";      
        try{            
            Connection connection = DriverManager.getConnection(url, "username", "password");         // Establish the database connection with necessary details  
              
           Statement statement  =connection .createStatement();   
                ResultSet resultset=statement.executeQuery("SELECT * FROM Users WHERE username LIKE 'a%' ");  // Execute a SQL query to fetch data from "Users" table where column name is not set, just for the demonstration  
              
            while(resultset.next()){              System.out.println("\nRecords are: \n");             User user = new User();          
                                                    user .setName ( resultset.getString("name"));     // Accessing column values using getters and setter methods  }                catch Exception e{System. out. println ("Error in JDBC operations ");          e.printStackTrace() ;}   finally {connection .close();}}