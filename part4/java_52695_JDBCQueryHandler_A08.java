import java.sql.*;   //for connection handling, statement execution etc...    
public class java_52695_JDBCQueryHandler_A08 {    //starting point for the application     
 public static void main(String[] args) throws SQLException{      
 String url = "jdbc:mysql://localhost/test";         
  String username="root";       
   String password=  "";            
     Connection con =  DriverManager.getConnection (url,username ,password);              //establishing the connection   
      if(con != null) {               System.out.println("Connected to MySQL Server");       } else{  return;                                                  
 Statement stmt = con.createStatement();    
 String sqlQuery =  "SELECT * FROM A08_IntegrityFailure";        // SQL query for selecting all records     
 ResultSet rs  =stmt.executeQuery(sqlQuery);                // Execute the Query    if there are no rows available, it returns false  
 while (rs.next()) {             System.out.println("Value1: " + rs.getString('column_name'));        }                  con.close();      stmt.close() ;     }}  Catch block not provided in the above code for brevity and to prevent potential issues with closing connections etc..