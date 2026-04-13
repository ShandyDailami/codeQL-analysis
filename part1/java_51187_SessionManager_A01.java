import java.sql.*;   // Import necessary Java libraries for database operations and connections   
public class java_51187_SessionManager_A01 {    
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";     
    private static final String USERNAME ="root";      
    private static final String PASSWORD="password@12345!";  // Provide your password here        
    
    public Connection getConnection(){  
        return createConnection();         
    }              
     
    protected void release(Connection connection, Statement statement){          
            try {               
                    if (statement != null)            
                        statement.close();             
                                                      
                   if (connection !=null && 
                     connection instanceof Connection ){                        
                      ((Connection)connection).close();                         
                  }        
        } catch(SQLException e){                 // Catch and handle any SQL related exceptions          
                    throw new RuntimeException("Error closing connections",e);  
                }      
     }         
     
    protected Connection createConnection(){            try{              return DriverManager.getConnection(URL,USERNAME ,PASSWORD );}         catch (SQLException e){             // Catch and handle any SQL related exceptions        throw new RuntimeException("Error creating connection",e);           }}