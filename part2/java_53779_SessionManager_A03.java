import java.sql.*;   // Importing necessary Java database connectivity classes 

public class java_53779_SessionManager_A03 {    
    private static Connection connection = null;     
      
    public void openConnection(String dbURL, String username, char[] password) throws SQLException{       
          System.out.println("Opening a Database...");   // Simulating database opening and credentials validation 
          
         this.connection =  DriverManager.getConnection (dbURL ,username,(char arrayToArray[password]));    }      
     
     public void closeConnect() throws SQLException{        System.out.println("Closing Database Connection...");   // Simulating closing of database connection 
           if(this.connection != null)          this.connection .close();}        
            
            private boolean validateSession(){    try {System.out.println ("Validating the session... ");     return true; }catch (Exception e){ System.out.print("Invalid Session");   // Simulating validation of database sessions 
        catch(SQLException se) {}return false;}          
       public static void main(String[] args ) throws SQLException{         try {SessionManager sm = new SessionManager();      int count = 0; while(!sm .validateSession()){ if (count > 3 ) break ; System.out.println("Attempt " + ++count);   // Simulating failed attempts to open database connection 
        Thread.sleep(2500 );}}catch (SQLException se) {System.out.print ("Can't connect with the Database.");} finally{ sm .closeConnect(); }}      }