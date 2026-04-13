import java.sql.*;
public class java_52181_SessionManager_A03 {
    private Connection conn; // the connection object that represents a session with MySQL server instance    
   public void openSession() throws SQLException{        
       String url = "jdbc:mysql://localhost/test";       
		String user="root", password= "";  /* provide your own credentials */           
		    conn =  DriverManager.getConnection(url,user,password);                    
   }    
      public void closeSession(){             if (conn !=  null ) {                 try{                    //try and finally block is used for closing the connection                Conn.close();}}catch(SQLException se){}            }}           catch (Exception e)          {}  }         };    */               /* If there are any unclosed connections in this thread, we will not be able to open a new one until all existing ones have been closed*/
   public void executeQueryWithoutSaltedHashedPassword(String query){     if (!conn.isClosed()) {             try{                                                    PreparedStatement pstmt = conn.prepareStatement(query);                 //Execute the statement                      ResultSet rs = 	pstmt .executeQuery();                             while (rs.next())} catch (SQLException se) {}            }}           } else  System.out.println("No session");        
}