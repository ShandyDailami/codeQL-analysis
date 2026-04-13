import java.sql.*;   // Import necessary classes from SQL API   
class java_42211_JDBCQueryHandler_A01 {     // Define a class named 'Example'      
public static void main(String[] args) throws Exception{      // Main method         
Connection con=null;                   // Connection object            
PreparedStatement pstmt = null ;        // Prepare statement           
ResultSet rs  =   null  ;                // Result set              
try {     /* Establishing connection */   
con   = DriverManager.getConnection("jdbc:mysql://localhost/testdb","username", "password");      con .setAutoCommit(false);       System.out.println("\nConnecting to database..." + "\n");   }catch (Exception ex){  // If there's an exception it will be caught here    
System.out.println("Database connection failed.");                   return;    }}           catch (SQLException se) {      Severe : a SQL Exception has occured        System.out.println("\nAn error occurred while executing the provided query..." + "\n");}  finally{                 // Finally block will execute this way           
if(pstmt != null ) pstmt .close();                /* Closing PreparedStatement */         }                    if (con !=null) {                  con.close(); }}        catch (SQLException se){    System.out.println("\nAn error occurred while closing connection..." + "\n");}