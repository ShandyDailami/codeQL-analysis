import java.sql.*;   // Import this for handling SQL exceptions, if any occurs (like connection failure) during the execution 
// JDBC Driver name is static in case we want a single driver instance across application life-cycle which can help to avoid repeated connections like Connection pooling issue etc., it should be loaded once at startup.  
class java_52084_JDBCQueryHandler_A03 {    // Declare your class as public so that other classes or methods could access this data 
public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/test";     
        String username="root", password=  "";  
         DriverManager driverMgr;    // Create a new instance of the MySQL JDBC drivers 
          Connection connection =  null ;            // Declare variable to hold Database connections, declare as static if multiple threads might be accessing database. (Connection pooling)     
        try {    
             Class.forName("com.mysql.cj.jdbc.Driver");   /* Register MySQL JDBC Driver */  }    catch(ClassNotFoundException ex){       System.out.println("JDBC driver not found.");}           // If the web app was unable to find a proper driver, it should print an error message and exit    
         connection = driverMgr.getConnection (url , username , password);   /* Create new connections */  try{    setAutoCommit(false) ;      }catch (Exception ex){ System .out.println("Cannot create transaction");}       // Set database autocommits to false for this session    
         PreparedStatement pstmt=null;        Connection con = null;   String queryString  = "SELECT user_id FROM users WHERE username LIKE ?" ;      try {    con =  DriverManager .getConnection (url ,username, password);           //Get connection instance. If there are no available connections in the pool then it will throw an exception    
         pstmt =con.prepareStatement(queryString );          }catch (SQLException ex){System.out.println("Cannot prepare statement");}      /* Prepare SQL query */    try {  for (;;);       String usernameToSearch="user";   // Set input parameter here you can also use prepared statements or parameters    
         pstmt .setString(1,usernameToSearch );              }catch (SQLException ex){ System.out.println("Cannot set the string");}      /* Bind a variable as an OUTPUT Parameter */    try {  ResultSet rs =pstmt.executeQuery();       //Execute query and get result    
         while(rs .next() )   }catch (SQLException ex){ System.out.println("Cannot execute the statement");}      /* Print all rows from a specific column*/        finally{if((connection != null))try { connection.close();  }} catch ( SQLException e) {}    // Close database connections if necessary    
}}   ;