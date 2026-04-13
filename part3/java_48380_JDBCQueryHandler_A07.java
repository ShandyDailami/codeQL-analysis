import java.sql.*;   // Import necessary classes from 'java' package   
class java_48380_JDBCQueryHandler_A07 {    
       static final String URL = "jdbc:mysql://localhost/testdb"; 
      // You should replace it with your own database url, username and password if they are different than the default.         
        private Connection conn;  
         public void connect(String userName , String passWord) {   
             try{    
                 Class.forName("com.mysql.cj.jdbc.Driver");  // Loading MySQL driver     
                  this .conn = DriverManager.getConnection (URL,userName,passWord);   }catch(Exception ex){       System.out.println ("Error in connecting to DB: " +ex );     }}          public boolean authFailureCheck() {    try{         PreparedStatement pstm= conn.prepareStatement("SELECT * FROM Users WHERE Auth_failure = TRUE");
                  ResultSet rs =pstm .executeQuery();        //If user exists in the database, it returns true       while(rs.next())  System.out.println ("Auth Failures detected!");      return false;    }catch (Exception ex) {System.err.print("Error: "+ex );     return false;}   }}