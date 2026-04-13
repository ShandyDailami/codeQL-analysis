import java.sql.*;   // Import necessary libraries from SL13_SQLInjectionPrevention package    

class java_49510_JDBCQueryHandler_A08 {   

 public static void main(String[] args) throws SQLException{       

 String url = "jdbc:mysql://localhost/test";      

 Connection conn= DriverManager.getConnection("url", "username","password");      //Establish connection with the database    

 Statement stmt  =conn.createStatement();   

 ResultSet rs;  

  String query ="SELECT * FROM users WHERE id = 1 AND password = '2'";        /*Replace values as per requirements*/      

  PreparedStatement pstmt= conn.prepareStatement(query);      //Preparing statement    

  pstmt.setInt(1,50 );    /***Set parameter value**/         

 rs  =pstmt.executeQuery();         /*Execute the query and get result set */       while (rs .next()) {        String userName=   ///Retrieving username using id from database    
  System.out.println(userName); }      conn.close();    //Close connection to DB after use}