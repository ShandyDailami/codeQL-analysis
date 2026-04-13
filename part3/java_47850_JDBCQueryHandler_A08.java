import java.sql.*;   //Import the necessary classes for database connectivity here   
public class java_47850_JDBCQueryHandler_A08 {     //Class definition name should be in camel case (Vanilla Java) and also matching with package structure if exists      
 public static void main(String[] args){     
  String url = "jdbc:mysql://localhost/test";   //Replace localhost, test accordingly to your setup   
  String username="root", password=  "";     //Assuming MySQL user is root and no pass-word set for security reasons (you need proper credentials in real scenario)      
      try {        
        Connection conn = DriverManager.getConnection(url ,username,password);   /*****Here you should provide your Database details like url & username***/     //Get the connection from database   
           String selectQuery="SELECT * FROM Employees";  //Replace table and field according to need (Eg: SELECT name,email From Users)     
         Statement stmt = conn.createStatement();   /*****Here you should provide your Database details like username***/     //Create a statement for querying   
        ResultSet rs=stmt.executeQuery(selectQuery);  ///Run the select Query on database and store result into resuet set     
          while (rs.next()) {   /*****Here you should provide your Database details like username***/     //Loop through each row of query results   
           System.out.println("Selecting one record");       Print out data in console by using println statement  }        conn.close();      ///Close connection to database after use         }}catch block for exception handling is provided below   */}}; catch (SQLException e) { //Handling SQL Exception here, It's not necessary when this code runs only inside the try-block but can be useful if you want more control over your error scenarios.