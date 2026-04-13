import java.sql.*;  // Import Java Database Connectivity (JDBC) API   
class java_45581_JDBCQueryHandler_A01 {    
      public static void main(String[] args){      
        String url = "jdbc:mysql://localhost/test";         
        String username="username1234567890_dbuserAdmin";   //replace with your db user name   
        String password="_passwordABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%^&*()_-+~`|}{[]:;?><,.";"   //replace with your db user pass
        try{            Connection con=DriverManager.getConnection(url ,username  , password);      Statement stmt =con .createStatement();     String sqlQueryString  ="SELECT * FROM Employee ";    ResultSet rs   =stmt.executeQuery (sqlQueryString );       while (rs.next()) {         System.out.println("ID : " + rs.getInt(1));          //printing ID   }      con .close();}
        catch (SQLException ex)  {}    finally{}     }}