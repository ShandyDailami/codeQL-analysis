import java.sql.*;   // Import the necessary classes for JDBC (Java Database Connectivity)   
                  
public class java_51698_JDBCQueryHandler_A01 { 
     public static void main(String[] args){      
           String url = "jdbc:mysql://localhost/testdb";      /* Provide your own MySQL server URL */        
           String username="root";                       // The user name used to connect the database         
           String password="password@1234567890";    /** Your actual mysql root Password here. It's not recommended for production as it contains sensitive data**/            
            try {        /* Create a connection */        
                 Connection conn = DriverManager.getConnection(url, username , password);      // Get the database connectivity instance 
                  System.out.println("Connected to Database");          }           catch (SQLException e)     {       /** Handle any SQL exception that may occur when connecting**/            
                            System.out.println ("Failed connection " +e );        }}                
            ;{                                                                                             try    /* Execute a query */                                              
                  Statement stmt = conn.createStatement();                                  // Create the statement to perform CRUD operations    
                   String sql="SELECT * FROM students";                                      // The SQL command for retrieving all records from table 1          } catch (SQLException e) {                      System . out .println ("Failed query " +e ); }}              ;}}    /* Close connections */                  try   { conn.close();                           stmt.close();}
                    catch(SQLException ex){                                                     Exit;                                                                      if ((conn != null))try{ conn.close(); }catch (SQLException e){ System . out .println ("Failed to close connection");}}  }} // Close the connections                  exitProgram: { return;}   /* Declare your main function */              public static void main(String[] args)