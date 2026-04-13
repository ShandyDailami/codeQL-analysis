import java.sql.*;   // Importing Java's SQL Connection Package    
public class java_45112_JDBCQueryHandler_A01 {
    public static void main(String[] args) {     
        String url = "jdbc:mysql://localhost/test";      
         
         try (Connection con =  DriverManager.getConnection("url", username, password))  // Here we are using the standard way to get a Connection with our credentials   
            {    
                Statement stmt=con.createStatement();     
                 String sql = "SELECT * FROM Users WHERE UserID='" + userid+"'";  
                  ResultSet rs =  stmt.executeQuery(sql);  // Execute Query to get a dataset from the database       
                      while (rs.next())    {    
                          System.out.println("User ID: " +  rs.getString('userId'));     
                           }           con.close();   })      
          catch Exception e1   {}  // Catch block for exception handling         try/catch blocks are not needed in this case due to simplicity of the task   
     }}`;