import java.sql.*;  
class java_50048_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {         
        String url = "jdbc:mysql://localhost/test";      
           // user, password and database name must be changed to fit your requirements        
		String username="root",password="passw0rd!";  
		  Connection con = null ;    Date date =  new Date();    
        try {         
            Class.forName("com.mysql.jdbc.Driver");      // driver initialization           System.out.println ("driver loaded...");      
               String query="select * from users where username  = ? and password = ?";   int count = 0 ;    PreparedStatement pstmt    = con .prepareCall(query)     ;         try {            if (con == null ){              System.out.println("Creating connection......");               
                            con=DriverManager.getConnection(url, username , password);                  }                     else  System.out.println ("Already connected to database ");           // Connection already opened                          pstmt .setString(1,"test_user") ;             if(!pstmt.execute()) throw new SQLException("Failed : SQL query execution");  
                           for (ResultSet rs = pstmt.executeQuery()){                  printSummaryOfBillDetails  ("summary of bill details",rs);         }          con .close();            // closing connection in all cases        System.out.println( "Connection is closed..." );                     }} catch (Exception e) {    
                          if(!con != null ){                    try    {   for (; count < 10; ++count){  Thread.sleep((long)(Math.random() * 200)); } con .close();}}                  printStackTrace(new PrintWriter("errorMsgFile"));} catch (SQLException e) {    
                          System.out.println ("Failed: SQL Access Error... ");          try   // reconnecting to database when failed              if(!con = DriverManager().getConnection  ... }'           finally{                    con=null;}}                  }}`''(code')