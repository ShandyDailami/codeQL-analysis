import java.sql.*;   // Import required Java libraries for database connectivity    
class java_53771_JDBCQueryHandler_A07 {   
      public static void main(String[] args) throws SQLException{        
          String url = "jdbc:mysql://localhost/test";       
           Connection conn=DriverManager.getConnection("","",""), 
            Statement stmt;   // PreparedStatements to prevent sql injection    
      try {      
             System.out.println ("Connecting to database...\n");         
                 
                   String selectQuery = "SELECT USER_ID, USERNAME FROM Users WHERE PASSWORD= ?" ;   
                         stmt  = conn.createStatement();   // Create a statement    
                          ResultSet rs;      // Store the result set of executed SQL Statements        
                          
                      try {             
                            String password = "password";        User userToVerifyPasswordAgainst =  new User("user", password);  stmt  = conn.createStatement();    PreparedStatement pstmt=conn.prepareStatement(selectQuery );      // Execute the query  
                             rs=  pstmt .executeQuery ( ) ;                while (rs.next()) {        String userNameInDB = rs.getString("USERNAME");         System.out.println ("User ID: " +userId+ ", User Name :"  +  userNameInDB);    }     
                   stmt= conn .createStatement();     if(isPasswordCorrect (stmt,conn , password)) {printWelcomeMessage () ;} else{ printAuthenticationFailed() ;}}        // end of main method   try         catch          finally            throws SQLException           {}  return;      
                      }    closeConnection(){      System.out.println("Closing connection to database...\n");     conn .close(); }}