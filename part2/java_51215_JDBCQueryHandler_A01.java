import java.sql.*;   // for Connection , Statement & ResultSet objects   
public class java_51215_JDBCQueryHandler_A01 {    
       public static void main(String[] args) {       
          String url = "jdbc:mysql://localhost/test";     
          String username="root";        
          String password="password";           // replace 'password' with your actual MySQL root user    passphrase for encrypted connection.  This is optional, it depends on how you setup the JDBC driver in Java (MySQL Connector or Tomcat)        Connection con = null;      Statement stmt =null ;
          try {              
             // Step1: Load Driver     if not available then load            Class.forName("com.mysql.jdbc.Driver");  }   catch(ClassNotFoundException e){e.printStackTrace();}    ResultSet rs= null;      con =  DriverManager.getConnection(url, username , password);         stmt =con .createStatement() ;
             // Step2: Execute the Query               String sql  ="SELECT * FROM users WHERE id>5";   rs=  stmt.executeQuery (sql)  } catch (SQLException e){e.printStackTrace();}     finally {           if(stmt != null )       stmt .close() ;        con    .close ()      }}catch ( SQLException se ){se.printStackTrace();}} // Closing connection and statement objects