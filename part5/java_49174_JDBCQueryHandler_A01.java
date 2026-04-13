import java.sql.*;   // Import Statements Here! (Please do not use external libraries, only standard library)   
public class java_49174_JDBCQueryHandler_A01 {    
 public static void main(String[] args){      private String url="jdbc:mysql://localhost/dbname";       Connection con;          try{           con = DriverManager.getConnection("url","user", "password");            System.out.println ("Connected to the database!");         Statement stmt =con.createStatement();    // create a statement object    
  ResultSet rs=stmt.executeQuery(“SELECT * FROM USERS” );      while (rs.next()) {        String userName  =   rs.getString("username");          System.out.println ("User Name : " +userName);           } con.close();    // close the connection
} catch Exception e{     println(e) ;  }}