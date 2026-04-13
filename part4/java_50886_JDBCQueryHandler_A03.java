import java.sql.*;  // Import necessary Java libraries for JDBC to work with database  
    import java.util.*; 
    
public class java_50886_JDBCQueryHandler_A03 {      
      public static void main(String[] args) throws SQLException{       
          String url = "jdbc:mysql://localhost/testdb";           
           Properties info=new Properties();                   // Creating properties object to connect database                   
              info.setProperty("user","root");                  // Setting user name and password  for the MySQL server        
               info.setProperty("password", "Kumar@1234567890$%^&*()_+=-[]|{}:;,?.>");          
            Connection con = DriverManager.getConnection(url,"root","Kumar@1234567890$%^&*()_+=-[]|{}:;,?.>"); // Get connection to database 
               Statement stmt  =con.createStatement();         // Create statement object          
                ResultSet rs =  stmt.executeQuery("SELECT * FROM users WHERE id = '" + userIdInput  + "' AND password ='"+password_input+  "' ");    // Query for the selected row       
                   while (rs.next()) {                        // Iterating through rows  of result set         
                       System.out.println(rs.getString("id") );             // Prints id      
                      }              stmt .close();                                con.close();   });                  };                    }}     `;