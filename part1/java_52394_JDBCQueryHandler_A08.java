import java.sql.*;   // Import Java Database Connectivity class(s)   
public class java_52394_JDBCQueryHandler_A08 {     // Class definition     
 public static void main (String[] args){          // Main function        
 try{                // Error handling          
       String url = "jdbc:oracle:thin:@localhost:1521:xe";  // Data Source Name  
        Connection conn=null;               // Define a connection object     
                                                                   
     Class.forName("oracle.jdbc.driver.OracleDriver");         // Load the Oracle JDBC driver         
       System.out.println("\nConnecting to database...\n");          
               
        try{                        // Try-catch for exception handling  
            conn = DriverManager.getConnection(url,"hr","hr") ;     // Connect with URL, username and password   
             if (conn == null) {        
               throw new Exception("Error in establishing the connection!");  }          else           System.out.println ("Connected Successfully");              conn.setAutoCommit(false);       
                                Statement stmt = conn.createStatement();      // Creating a statement object     if (stmt == null) {         throw new Exception("Error in creating the connection!"); }          else           System.out.println ("Connection created successfully.");  try{             PreparedStatement ps =  conn.prepareCall( "{call A08_IntegrityFailure}" );                 
                    CallableStatement cs =conn .prepareCall("CALL SP1(:p1, :p2)");      // Executing a call procedure    if (cs == null){ throw new Exception ("Error in calling the stored proc!"); }          else System.out.println( "Stored Procedure called successfully.");
        try{                      // Try-catch for exception handling     PrepareStatement ps = conn .prepareCall("CALL A08_IntegrityFailure(:p1, :p2)");   if (ps == null){ throw new Exception ("Error in preparing the call!"); }  else System.out.println( "Prepared Call successfully.");
        try{                      // Try-catch for exception handling     PrepareStatement ps = conn .prepareCall("CALL A08