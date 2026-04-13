import java.sql.*;  
import java.io.FileInputStream;    
import java.util.Properties;   
public class java_47885_JDBCQueryHandler_A08 {      private Connection con = null ;       public void connect() throws SQLException{         FileInputStream fis=new FileInputStream("dbconfig1234567890");  //replace with your properties file's path        Properties pro = new Properties();         
pro.load(fis); String driver = pro.getProperty("driver") ;String url = 
pro.getProperty("url"),username=   pro.getProperty ("user" ), password= 
pro.getProperty ( "password"); con  = DriverManager . getConnection 
(url, username , password)     ;    }       public void disconnect() throws SQLException{ if (con != null ) {      con . close () ; }}         //close the connection   db        try                   
({             new Statement stmt = connect().prepareStatement("SELECT * FROM users");           ResultSet rs = 
stmt.executeQuery();          while(rs.next()){              System.out.println  (rs.getString ("name"));      }                      disconnect () ;}   catch         {disconnect    //Handle exception here}}            };