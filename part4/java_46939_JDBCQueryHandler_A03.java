import java.sql.*;  // Import necessary Java libraries  

public class java_46939_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test";      
          DatabaseCredentials credentials =  new MySqlDatabase();             
          
          try (Connection con  = DriverManager.getConnection(url,credentials.username(), credentials.password()))  //Establishing the connection with database   
         {  
             Statement stmt = con .createStatement();    
               String SQL= "SELECT first_name FROM employees WHERE department_id = 1";     
                ResultSet rs=  stmt.executeQuery(SQL);       
                 while (rs.next())       //Iterating through each row in the result set  
                  {                   System.out.println("Name :" + rs.getString("first_name")); }    
             }    catch  ( SQLException ex )         {}                     finally{}     
                DriverManager.deregisterDriver(con .getClass().getDriver()); // closing the connection         
        }}