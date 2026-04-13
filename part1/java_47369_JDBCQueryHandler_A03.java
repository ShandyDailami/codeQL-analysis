import java.sql.*;  // Import Statements for SQL related classes  
public class java_47369_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws Exception{       
            String url = "jdbc:mysql://localhost/testdb";     
              Connection connection  = null;      
                try{            
                    // Load the MySQL driver 
                        Class.forName("com.mysql.cj.jdbc.Driver");  
                         
                       // Establish a new database connection         
                         connection = DriverManager.getConnection(url,"username", "password" );     
                            if (connection != null) {           System.out.println ("Connected to the MySQL server successfully.");     }            else{  throw new SQLException("Cannot get Connection");}    // Close database resources          try  
                          finally                  
                    /* Finally block will be executed whether exception is thrown or not */        
                             connection.close();                  System.out.println ("Connection Closed!");          
                }}catch (SQLException e) {  printStackTrace(e)};    // Catch and handle the SQL Exception       catch   }}}        finally            Close database resources          try {}      after each statement is executed, this block will be run whether exception occurred or not.     System .out‌​Println ("Closing connection");