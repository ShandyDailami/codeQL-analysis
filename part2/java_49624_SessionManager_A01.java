import java.sql.*;  // Import the required Java library packages, you may need them individually if needed too (e.g., Oracle JDBC driver)
  
public class java_49624_SessionManager_A01 {
    
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";     
    //Change the values accordingly to match your database configuration - username, password and so on. 
          
    public Connection getConnection(String userID) throws SQLException {       
       return DriverManager.getConnection(URL,"username","password");  
          //Replace 'username' & 'password', with actual Oracle credentials if required        
 }     
    
public void storeSession(String sessionId, String username){   
           try{           
               Connection con = getConnection();       
                PreparedStatement pstmt; 
                  string query="INSERT INTO SessionTable (sessionID ,username) VALUES('"+sessionid + "','"  + userName +  "')";   //Change the column names to match your database schema.   
                          doWork(con,query);     };            catch {        e.printStackTrace();  }      finally{           if( con != null )          try { con.close();}catch (SQLException se){};              }}                  throw new RuntimeException("Something went wrong while trying to store session data.",e);            
    });        
   //Add the appropriate exception handling and recovery mechanisms for your code       }        private void doWork(Connection connection, String query) {           try{               PreparedStatement pstmt =connection.prepareStatement (query );pstmt .executeUpdate();}catch{}finally {}//handle exceptions as needed}};