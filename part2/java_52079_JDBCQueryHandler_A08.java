import java.sql.*;
  
public class java_52079_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{      
        // Establish a database connection by calling the method named connectDatabase()         
            Connection con = connectToDB();          
             if (con != null){   /* If statement to ensure we have connected successfully */ 
                 handleSecurityOperationWithHash(con);    }     else {       System.out.println("Connection not established.");      return;        }}         public static Connection connectToDB() throws SQLException{          String url = "jdbc:mysql://localhost/test";           // URL of the MySQL database 
String userName="root", password="password123456!" ;     Class.forName("com.mysql.cj.jdbc.Driver"); /* Loading JDBC driver */        Connection con = DriverManager.getConnection(url,userName , password);      return (con != null) ?  con :   throw new SQLException("Cannot connect to database!" );    }}