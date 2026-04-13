import java.sql.*;   // Import the necessary Java packages here...(We'll just import Connection, PreparedStatement and ResultSet)
   
public class java_46878_JDBCQueryHandler_A08 {      // Define a new public static inner class called 'JDBCQueryHandler'. (In this case only one handler for simplicity.) 
    
   private final String url;          // Declare the necessary variables. These will be used to set up our connection with database later on...(Should match your actual data source settings)   
   private final String username;     
   private final String password;      
        
// Constructor for JDBCQueryHandler, takes in url and credentials as parameters  (In this case only one constructor here).     // Define the necessary details. These will be used to establish a connection with database later on...(Should match your actual data source settings)   
   public java_46878_JDBCQueryHandler_A08() {         
       throw new UnsupportedOperationException("This is not supported and you should use Builder pattern.");  }           this line throws exception if called directly      // Throw an error to prevent instantiating a class in unsuppored mode. (Only way we can do it here)    private static Connection conn;  
        
// Constructor for JDBCQueryHandler, takes parameters url and credentials       public String getPassword() { return password;}     Return the needed Password from method // Returns necessary details to setup a connection with database later on...(Should match your actual data source settings)    private static PreparedStatement pstmt;  
        
// Method for JDBCQueryHandler, takes parameters url and credentials       public String getUrl() { return this.url;}     Return the needed URL from method // Returns necessary details to setup a connection with database later on...(Should match your actual data source settings)    private static ResultSet rs; 
        
// Method for JDBCQueryHandler, takes parameters url and credentials       public String getUserName() { return this.username;} Return the needed User Name from method // Returns necessary details to setup a connection with database later on...(Should match your actual data source settings)    private static Connection conn;   }
}  */     )//Close bracket for JDBCQueryHandler class (this line should not be changed unless you are sure about what is going in the code below it.)         // This comment only to explain how this program will work and won't run on its own.    public static Connection getConnection() throws SQLException {   conn = DriverManager.getConnection(url, username , password);  return conn; }