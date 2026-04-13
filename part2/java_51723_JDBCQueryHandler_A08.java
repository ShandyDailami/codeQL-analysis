import java.sql.*; // You need to import these libraries at the top of your file 
// for all JDBC functionalities (like Connection object creation etc)
  
public class java_51723_JDBCQueryHandler_A08 {   
     public static void main(String[] args){     
         String url = "jdbc:yourDriver"; // Replace with actual database driver and URL         
         Properties info = new Properties();      
           
        try{            
           Class.forName("com.mysql.cj.jdbc.Driver");  /*You need to import this library if you're using MySQL as JDBC Driver*/     // Use your actual Database driver here   
                  
          info.setProperty("user", "root");      // Encrypt sensitive information (like database username and password)      
           String dbPassword ="yourpassword";   /*You need to encrypte this, use a secure method like Bcrypt or similar */     // Use actual Database Password   
            info.setProperty("password",dbPassword);     
            
          Connection conn=DriverManager.getConnection(url ,info );         System.out.println ("Connected");  }catch (Exception e){System.err.format("Failed to connect: %s\n",e)};     }}