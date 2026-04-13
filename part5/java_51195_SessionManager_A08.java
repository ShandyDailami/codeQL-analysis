import java.sql.*;   // Import necessary SQL classes and objects here   
public class java_51195_SessionManager_A08 {    
      private static final String URL = "jdbc:mysql://localhost/mydb";      
      private static final String USERNAME="root";       
      private static final String PASSWORD  = "";  // Password is set as empty for security reasons        
   public Connection getConnection(){            
          try{                
                Class.forName("com.mysql.cj.jdbc.Driver");              
            return DriverManager.getConnection(URL,USERNAME ,PASSWORD);              }                   catch (Exception e){                          System.out.println ("Error while connecting to MySQL" +e );                      }   
  public void closeQuietly(ResultSet rs) {       if ((rs != null)) try {   rs.close();}catch(SQLException se){}     }         catch (SQLException sqle) {}      // Close the statement and result set even when throwing exception                  }               
  public void closeQuietly(Statement stmt ){        if((stmt !=  null))try {          stmt.close();   }catch (SQLException se){}    try{            Connection conn = stmt.getConnection();           ((Connection)conn).close();      }}       catch (Exception ex){ System .out ("Error while closing statement" +ex);}}