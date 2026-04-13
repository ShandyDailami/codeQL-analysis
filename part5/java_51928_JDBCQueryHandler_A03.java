import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource; // use c3p0 instead of HikariCP 
// or any other connection pool library you prefer, like MySQL's native Connector/J (native-jdbc) for JDBC operations  
public class java_51928_JDBCQueryHandler_A03 {
    private static ComboPooledDataSource dataSource;    
      
    public static void main(String[] args){        
        initializeDatabase();                 // Initialize Data Source, can be called once. 
                                              // This is done in a way that the application starts up and shuts down gracefully to free resources (i.e., connections) as necessary  
          
          try {                             // Try block containing SQL operations    - Use JDBC transactions if needed        
                Connection conn = dataSource.getConnection();  // Obtain connection from pool                 
                          
             String sql  = "INSERT INTO Users(Name,Email) VALUES (?,?)";    
              PreparedStatement pstmt=conn.prepareStatement(sql);           
               for (int i = 1; i <= 50 ;i++){                                          
                // use '?' placeholders in prepared statements  
                 String name = "User" + Integer.toString(i)  ;    
                  String email  =name+"@example.com";   
                   pstmt.setString(1, name);                     
                    pstmt.setString(2 ,email );        // set each parameter value        
                           pstmt.executeUpdate();                     // Execute operation         
                }          
              conn.close();  // close connection after operations are complete                 
               System.out.println("Data inserted successfully");   
            } catch (SQLException e) {                             // Catching any exception that may occur in database related exceptions  
             e.printStackTrace();                          // Print stack trace for debugging      
           }        
        dataSource.close();  // Closing connection pool     when done with app         
    };                 
              
 private static void initializeDatabase(){     
            if(dataSource == null){                    
                try{                                    
                    String driver = "com.mysql.jdbc.Driver";                      
                            Class.forName(driver);                         // load MySQL JDBC Driver class  
                                           dataSource=new ComboPooledDataSource("example");  // Use C3P0, but you can use HikariCP or any other library                     if (dataSource == null) {     cx = new DataSource();      ((ConfigurableDatasource)cx).setDriverClass(driver);          } catch......
                }}catch...}};  // closes database connection when done with app    private static void initializeDatabase(){ ... };   });       data_source.close() to close the pool upon application termination for this example, but it's not recommended in production code due to resource leaks and thread safety issues */