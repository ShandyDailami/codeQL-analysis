public class java_49636_SessionManager_A08 {
    private static int numClosed = 0; // Count of session close attempts in a row without success, this will be used to determine if we consider the connection as open and potentially expire it when needed (A29 Assignment)
    
    public void startSession() throws Exception{ 
        try {  
            connectToDB();// Connects with DBMS. Replace 'connect' method in below code using actual JDBC API calls to create a session here and establish connection if required by database server settings such as protocol, port etc., you may need additional library for this task like java.sql or com.*
             System.out.println("Session started");   // Prints message on console when starts of the program 
        } catch (Exception e) {   
            throw new Exception ("Failed to start session",e);// Throws exception in case connection fails, you may need additional logging here like log4j or similar libraries for this task.    
         }  
       } // end method beginSession     
  public void close(java.sql.Connection con) throws SQLException{    try {                System.out.println("Closing session");           /* Logic to be implemented as per requirement, e.g., set some properties of connection if required*/    		  	con = null;            // Closes the Session in DBMS
        numClosed = 0 ;  } catch (Exception ex) {      throw new Exception ("Failed closing session",ex);    /* Logic to be implemented as per requirement, e.g., increment and/or set a flag if necessary */}  		}// end method closeSession     //end of the code