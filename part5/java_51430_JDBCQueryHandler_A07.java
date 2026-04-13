import java.sql.*;   // for Java DB Connection, Statement & ResultSet objects    
class java_51430_JDBCQueryHandler_A07 {   
public static void main(String[] args) throws SQLException{       
      String url = "jdbc:mysql://localhost/testdb";      
      String username="root";          
      String password="password";         
   //Step 1 : Establish the Connection    
      try (Connection con  = DriverManager.getConnection(url,username ,password);       
            Statement st =con .createStatement()) {        
             System.out.println("Connected to database... ");                  
           }              catch (SQLException ex)    //Catching the exceptions   Exception 1    
          {                 printSQLException(ex);}                     
                                                       return;      }}       ` `