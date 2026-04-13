import java.sql.*; // Import required Java packages 
  
public class java_42273_SessionManager_A03 {   
      private Connection connection;    
      
      public void openConnection(String dbUrl, String username, String password) throws SQLException{        
          this.connection = DriverManager.getConnection(dbUrl,username,password);        }            
          
      public ResultSet executeQuery(String queryStr)throws SQLException {            return connection.createStatement().executeQuery (queryStr );       }}             
              
public class SessionExample{   // The main program 
    private static final String DB_URL = "jdbc:mysql://localhost/test";    
        public static void startSession() throws Exception      {}          if(session == null) {            sessionManager.openConnection (DB_URL, "user", "password");             Session newSession=   // open a connection  } else{    throwException("Cannot create more than one sessions!");}        
           public static void main methodString [] args throws Exception      {}          if(session == null) startSessioN();            session.closeConnection ( );}}       End of SessionExample program`             ^Caption: [Exit]  I've cut it, thanks for your patience and understanding!