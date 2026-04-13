import java.sql.*;
public class java_49770_JDBCQueryHandler_A07 {  
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // Replace with your actual database URL, username & password should be provided when you connect to the MySQL server using JDBC 
    
    public boolean checkAuthFailure(String userName) throws SQLException {  
        Connection connection;     
           try{           
                Class.forName("com.mysql.cj.jdbc.Driver"); // Loading Driver (JDBCDriver - MySQL Connector/J in this case, you need to have the driver installed on your system) 
                 System.out.println("\nConnected\n");  
                  connection = DriverManager.getConnection( DB_URL,"username","password" ); // Replace with actual username and password of database user   
             }catch (Exception e){        
                System.out.println("Could not connect to MySQL Server!"); 
                    throw new SQLException();  
              }       
           Statement stmt = connection.createStatement(ResultSet.TYPE_ALL, ResultSet.CONCUR_READ_ONLY);     // Creating a statement using the database connection      
         String sql="SELECT USER() FROM DUAL WHERE (USERNAME LIKE '"+userName+"' AND PASSWORD = 'password')";  // Replace password in this SQL query with actual one. This will only check if user name and Password match, without checking any other data
         ResultSet rs= stmt.executeQuery(sql);  
           boolean authFailed = false;    // Boolean to indicate whether authentication failed or not      
          while (rs.next()) {  /* If UserName matches with the username from database and Password also matched */               System.out.println("User is authenticated successfully.");         } else{authFailed=true;}      rs.close();     stmt.close();    connection.close();  
           return authFailed; // Returns true if authentication failed, false otherwise 
       }}`} end of the code! Please replace "username" and password with your actual username/password in DB_URL String & sql query as per requirement for real-world application scenario.. Happy Coding