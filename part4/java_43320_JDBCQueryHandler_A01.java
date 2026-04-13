import java.sql.*;   // Import necessary classes from JDBC package    
public class java_43320_JDBCQueryHandler_A01 {   
    public static void main(String[] args) throws SQLException{         
        String url = "jdbc:mysql://localhost/test";        
        Connection conn=null;          
       try  // Begin of 'try' block for database operations.    
            {              
                System.out.println("Connecting to the specified MySQL database...");            
                
              /* Step1-Open a connection */   
                conn = DriverManager.getConnection(url, "username", "password");          // Replace username and password with actual values        
                  if (conn == null)     {           System.out.println("Failed to connect to the database..."); throw new SQLException(); }        else   {                 printAvailableTablesAndColumnsInDB((Connection) conn, url );}       }          // End of 'try' block for Database operations   
               catch (SQLException e){            /* Step2-Handle any errors that may occur when using the Connection or Statement objects */         System.out.println("Caught an SQL exception... ");        printStackTrace(e);   }}  ;     // End of 'catch' block for Database operations   
               finally{             conn = null;}}// Close database connections here if anything is left unclosed           }      /* Step3-Close the connection at the end */          private static void closeConnection (java.sql.Connection con) {if(con !=null){try{dbcp2DriverManagerFactoryClassConnections .close();}catch (Throwable exc){System.out.println("Cannot disconnect from database");exc.printStackTrace()}};} // Close connection at the end of JDBC program  
               private static void printAvailableTablesAndColumnsInDB(Connection conn, String url) throws SQLException  {      ResultSet rs = null;     PreparedStatement smt=null ;           try{       /*Step4-Query to get all table names in the database*/          System.out.println("Database URL: " +url);smt =  conn .prepareStatement ("SELECT CURRENT_USER() FROM DUAL");  rs = smt.executeQuery();      while (rs.next()) {System.out.print(rs.getString(1));}}catch (SQLException se)     {}finally{if (!conn.isClosed()){closeConnection( conn );} } // Close statement and resultset here at the end of JDBC program   
               private static void printStackTrace(Throwable e ) {System .out ("Caught an SQL exception... ",e);for (StackTraceElement ste[] = e.getStackTrace()){ System.out("\t at " +ste[0].toString());}} // Print the stack trace of exceptions