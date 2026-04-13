import java.sql.*;  // Import necessary classes for JDBC connections & queries     
   import java.util.Properties;    // To read properties files    
      
public class java_51284_JDBCQueryHandler_A01 {        private static Connection conn = null ;         public Object dbConnection()          try             
{            Class.forName("org.sqlite.JDBC");             System.out.println("\nConnecting to database...");                     String url="jdbc:sqlite:"+System.getProperty("user.dir") + "/testdb";    Properties props = new Properties();             
props.setProperty("user","sa"),  //User name  
               props.setProperty("password", "your_pwd");     conn =  DriverManager.getConnection(url, props);                       return null;        }           catch (ClassNotFoundException | SQLException e)          {                System.out.println("\nError in DB connection..."+e );         return 0 ;       }}