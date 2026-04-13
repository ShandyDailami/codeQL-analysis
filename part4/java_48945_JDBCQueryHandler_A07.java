import java.sql.*;   // Import necessary Java SQL classes 
class java_48945_JDBCQueryHandler_A07 {   
public static void main(String[] args) throws Exception{    
        String url = "jdbc:mysql://localhost/test";      /* Your database URL */      
        String username="root", password="password1234567890!";  // Provide your MySQL Username and Password (Keep in mind, this is not recommended for production environments)   
         Connection con = null ;     DriverManager.registerDriver(new com.mysql.jdbc.Driver());   /* Register the driver */      
        try {con=DriverManager.getConnection(url ,username,password);}  catch (SQLException e1){ System.out.println("Error in connection"+e1)};      // Establish Connection    if there is any SQL Exception then print it out with system Print Statement  
        PreparedStatement pstmt = null ;     ResultSet rs=null;       String queryStr=  "select * from users where username=? and password=?"  /*SQL Query */          try {pstmt =  con.prepareStatement(queryStr);}catch (Exception e){System.out.println("Error in Preparing Statement"+e)} ;      // Prepare the SQL statement for execution    
        pstmt .setString(1, "userA");  /* Set Value */             try {pstmt .executeUpdate(); } catch (SQLException ex)   { System.out.print ("Could not execute update operation because of: " +ex);} ;       // Execute the SQL statement    
        pstmt  = con.prepareStatement(queryStr );    setInt(2,"10");  try{pstmt .executeUpdate(); }catch (SQLException e){System.out.println("Error in Preparing Statement"+e)};         /* Set Value */       // Execute the SQL statement    
        con.close();          if((con==null)) System.out.print ("Connection closed");      try {if(pstmt != null) pstmt .close();} catch (SQLException e){System out println("Could not close PreparedStatement"+e); }  /* Close the prepared statement */      
        // End of program    
    }}`