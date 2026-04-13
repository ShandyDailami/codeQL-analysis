import java.sql.*;

public class java_47586_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost/test"; // replace with your actual database url, should be in the form of jdbc:[scheme]://[host]:[port]/[database_name], e.g., mysql://127.0.0.1:3306/mydb
    private static final String USER = "root"; // replace with your actual username, usually 'root' for MySQL is used as default user 
    private static final String PASSWORD = "";// if using password-based authentication then include the corresponding database credentials in here else leave it empty. Replace ''(empty string) also when you use this code on a server environment or production system with real databases username and required passphrase/password for MySQL user 'root'
    private static Connection connection;  // Declare your variable to hold JDBC objects of type "Connection" only once, instead declare it in every method. It is thread-safe because we are using a single instance per the application (i.e., Singleton pattern) - so there will be one and same object used across all threads
    
    private java_47586_JDBCQueryHandler_A01() {} // prevent instantiation of this class via 'new' keyword by declaring constructor as protected/private to achieve singletons behavior i.e, the instance should only exist within a single JVM in multithreaded environment 
  
      static {       
          try{              
              Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL database driver          
                  connection = DriverManager.getConnection(URL, USER ,PASSWORD);// creating the db connectivity here                  
          }catch (ClassNotFoundException e){ 
            System.out.println ("MySQL JDBC Driver is not found in classpath!");    //Printing error message when driver not available  
              e.printStackTrace();                 
         }                                  
      }                                          
                                                                      
     public static Connection getConnection() {// Returns the single instance of 'connection' for any request/call from other classes or methods         
        return connection;  //Returning our Singleton Database Connection                    
    }            
}