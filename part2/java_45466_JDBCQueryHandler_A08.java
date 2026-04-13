import java.sql.*;   // import necessary Java packages/libraries    
class java_45466_JDBCQueryHandler_A08 {    // Class declaration with name of the class i.e., 'JDBCQueryHandler'     
public static void main(String[] args) throws SQLException{       //main method starts here       
  String url = "jdbc:mysql://localhost/db";     // JDBC URL to access MySQL database   (replace with your actual DB details)   
  String username="root";         // Replace 'username' and ''password'' in the below string placeholders ('')      you should use a real password here      
  String password = "";            
        try {            //try block to catch exceptions if any occur          (Useful for handling SQL Exceptions)    
    Connection con=DriverManager.getConnection(url,username,password);         //establish connection with database      return null;   }               
       Statement stmt = con.createStatement(); 
        ResultSet rs ;             // Declare a variable 'rs' to hold the result set from our SQL Query    String sql="SELECT * FROM yourTable";     (replace "yourTable")          
         /*Calling select statement on Database*/               
       rs = stmt.executeQuery(sql);                  PrintResultSet  //print results of a query          while (rs !=  null) {                   System.out.println("Column1:Value Column2..." ); }                       con .close();               return ;   }} catch block to handle exceptions