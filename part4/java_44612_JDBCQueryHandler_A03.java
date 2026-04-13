import java.sql.*;   // Import required classes for JDBC (Java Database Connectivity) API here..   
public class java_44612_JDBCQueryHandler_A03 {     // Create a public main method to run your program...      
static Connection con = null;  // Define the static connection variable, it will be used in place of 'this' when invoking methods on this object.     
  
// Method for establishing database connections......    .. ... .        .........     Java Syntactical Correct Code:
public void establishConnection() {       try{                con = DriverManager.getConnection("databaseURL", "username" ,  "password");             } catch (SQLException se)   // Exception handling for JDBC connectivity...    .. ... .        .........     Java Syntactical Correct Code:
                                                   System.out.println(se);            throw new SQLException();         }      finally {                 if(!con.isClosed()) con.close() ;          }}  // Ensure the connection is closed at end of program...    .. ... .        .........     Java Syntactical Correct Code: