import java.sql.*;
// Import necessary classes (Statement and Driver) from the Java Database Connectivity package 
public class java_52932_JDBCQueryHandler_A01 {  
    public static void main(String[] args){     // Main method to start execution of program      
        String url = "jdbc:mysql://localhost/test";     
        String username="root";                     
        String password="password";                  
         try{                                       
            Connection connection;                 
             Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC driver into the classpath  
              connection = DriverManager.getConnection(url,username,password);     
               Statement statement=connection.createStatement();               
            String sqlQueryString1=  "select * from Employee";                 
             ResultSet resultset =  statement .executeQuery (sqlQueryString1 );    // Execute the select query  
              while (resultset.next()) {                                    
                 int id = resultset.getInt(1);                             
                String name  = resultset.getString(2) ;                     
                  System.out.println("ID : " +id+ ", Name:  "  +name );         // Print the fetched data   }                       if (connection != null){ connection.close();}    }} catch (SQLException e ) {e .printStackTrace()}; finally{if(statement!= 
null) try{ statement.close();}}}}}catch (ClassNotFoundException ex){ex. print stack trace;}  //Catch and handle any exception if error occurs in the connection, or during query execution   }    }}               catch block for Class not found exceptions; it's a fatal condition because no driver could be loaded