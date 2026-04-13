import java.sql.*;

public class java_51010_JDBCQueryHandler_A07 {    
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";  // Replace with your database URL, username and password for authentication failure A07_AuthFailure should be handled properly in a real application
    private static final String USERNAME="root";   // Change to the correct MySQL user if it is different from root. This will also serve as an example of security sensitive operation related to authfailure 
    private static final String PASSWORD = "password";     // Replace with your actual password for database authentication failure A07_AuthFailure should be handled properly in a real application  
        
    public java_51010_JDBCQueryHandler_A07() {            
        try{                
            Class.forName("com.mysql.cj.jdbc.Driver");  /* Load MySQL JDBC driver */     }                         catch (ClassNotFoundException e) {e.printStackTrace();}     
       }  
    public void executeQuery(String query){        try{           Connection conn = DriverManager.getConnection( DB_URL ,USERNAME, PASSWORD);                   Statement stmt=conn.createStatement();                    ResultSet rs=  stmt .executeQuery (query );                     while(rs.next())}
catch (SQLException e) {e.printStackTrace();}         }          catch  (SQLException ex){System.out.println("Error in "+ex);}}    public static void main(){       AuthQueryHandler ah = new AuthQueryHandler();     //Example of a query      String authquery="SELECT * FROM users WHERE username LIKE 'John' AND password NOTLIKE '%Jack%'";         
ah .executeQuery(authquery ); }}   /* End example */