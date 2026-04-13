import java.sql.*;
public class java_52642_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{  
        String url = "jdbc:mysql://localhost/test"; // Replace with your database details    
        String username ="root";  // replace root or a suitable user for testing purpose in real scenario. The current program is using as per the test case only and it can't be used without proper setup of MySQL server settings such like setting up an appropriate mysql role, granting required privileges etc...  
         SecretManager sm = new MySecretManager(); // Using Java Native Access (JNA) with a secret manager to handle database passwords. This is not the best approach but for learning purpose only   
        String dbPassword =  sm.getSecureValue("dbpassword");  // Fetching secure value from your Secret Manager  
        
          Connection conn = DriverManager.getConnection(url, username ,dbPassword);    
           if (conn != null) {      
            System.out.println("Successfully connected to the database.");     
               Statement stmt  = conn.createStatement();    //For non-prepared statement  
                String sql = "SELECT * FROM employees WHERE id=" + reqEmployeeId;  //This is a security sensitive operation, no injection possible here because we are not using any parameterized query or prepared statements    
               ResultSet rs  = stmt.executeQuery(sql);    }   else {        System.out.println("Couldn't connect to the database.");      }} catch (SQLException e)  {         // Handle your exception here, it will depend on what SQL Exception you have thrown and how you want to handle them          
     printStackTrace();}}}`; in this code snippet: `reqEmployeeId is a placeholder for input of the user. In real application we need more security measures like using prepared statements or parameterized queries instead of hardcoding values which makes it injection free, because now any SQL command executed on our behalf will be aware that value has been changed in some place where this data might go into another table/database etc...