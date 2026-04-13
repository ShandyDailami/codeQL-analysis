import java.sql.*;   // Import required classes from JDBC package   

public class java_52729_JDBCQueryHandler_A03 {    
      
      public static void main(String[] args)       
        throws SQLException, ClassNotFoundException        
      {           
           String url = "jdbc:mysql://localhost/test";   // URL of MySQL database 
           String username="username_here";    // your actual user name in the mysql server.    
           String password="password_here";       //your real db Password here                
           
          Connection con = DriverManager.getConnection(url, username , password);  
                 
         Statement stmt  =con.createStatement();             
               
         ResultSet rs =  stmt.executeQuery("SELECT * FROM USERS WHERE AGE > 20"); // here we are performing a security-sensitive operation related to injection attacks 
                  
           while (rs.next()) {         
               System.out.println(rs.getString("name") + " age: ");      
                }       
                  rs.close();      stmt.close();     con.close();   // close connections after use        
             };           
};