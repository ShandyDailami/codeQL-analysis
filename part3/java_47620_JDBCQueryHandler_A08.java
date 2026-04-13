import java.sql.*;
public class java_47620_JDBCQueryHandler_A08 {   
     private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname"; // change it to your database url and name
     private static final String USERNAME ="your username here ";  //change this accordingly  
     private static final String PASSWORD="password Here, use Base64 for decoding the password in JDBC driver!";//use base64 encryption. Password must be kept as secure sensitive information and not visible to users or developers because it is handled by your DBMS Server on application level
     public static void main(String[] args) {   //you can add more methods if needed, just make sure you call them in the right order    } 
       try{       
            Connection conn = DriverManager.getConnection (DB_URL , USERNAME , PASSWORD);     
             Statement stmt  =conn .createStatement();    
              ResultSet rs ;   //execute your SQL query here, for example: "select * from users"  and set it to a variable like `rs`.    } catch (SQLException e) {e.printStackTrace( );} finally{try/finally block is used in order not letting the resources leak into case when an exception occurs because of improper handling or other errors that may occur while accessing database, so make sure to handle them properly like above example do!}}