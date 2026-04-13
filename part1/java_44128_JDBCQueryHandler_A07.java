import java.sql.*;   //for all Java Database Connectivity (JDBC) related operations including Connection Pooling etc., Statement and PreparedStatement classes    
     
public class java_44128_JDBCQueryHandler_A07 {   
// create the method for fetching user data with username or id from database using a statement, not recommended as it's insecure. 
 public static ResultSet executeSelect(String query) throws SQLException{   //execute select operation on an existing connection and return result set object of that execution    
        Connection conn = null;    try {conn=DriverManager.getConnection("dbUrl","userName", "password");} catch (SQLException e1){e1.printStackTrace(); }     
         Statement stmtOut  =   conn .createStatement();  ResultSet rs   =stmtOut.executeQuery(query);    return rs;     //returning result set object of the execution         
       }       
}               public class Main {            static Connection connection = null ;              try{connection=DriverManager.getConnection("dbUrl","userName", "password");                  Statement stmtOut  =   connection .createStatement();             ResultSet rs   =stmtOut.executeQuery(query);                   while (rs.next()) {}          
 }     // Main method to test the code         public static void main(String args[]) {               try{  executeSelect("SELECT * FROM USERS");} catch (SQLException ex){System .outprintln ("Error in executing SQL Query: " +ex);}}                     }}