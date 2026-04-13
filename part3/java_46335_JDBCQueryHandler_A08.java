import java.sql.*;   // Importing necessary Java database APIs from the JDBC package   
    
public class java_46335_JDBCQueryHandler_A08 {      // Main Class to handle all queries through this point in time       
// Creates a Connection object that can interact with your Database 
Connection con = null;          
Statement stmt=null, rs=null ;  
ResultSet res=null;    
public java_46335_JDBCQueryHandler_A08() {       //constructor    }      public static void main(String[] args) {          System.out.println("Welcome to JAVA JOURNEY!");        try{           con = DriverManager.getConnection ("jdbc:mysql://localhost/testdb", "root" , "password"); stmt=con.createStatement();    
// Execute your SQL commands, such as SELECT / INSERT queries here...          } catch (SQLException e) {             System.out.println("Error Occurred while connecting to the database..." +e);        }   // Close resources finally block    try{         stmt = con .createStatement();     rs=stmt.executeQuery(select_query );      
// Process result set...          if (rs != null) {                while (rs.next())             System.out.println("Records are found for this query..."); } catch (SQLException e){            ConsoleHelper.printConsoleMessage("\n\tError in retrieving the records from DB: " +e, Color.RED_BOLD );      
//  con .close();         rs.close();     stmt . close() ;   System.out.println("Connection Closed"); } catch (SQLException e) {             ConsoleHelper.printConsoleMessage("\n\tError in closing the database resources... " +e, Color.RED_BOLD );}
    // END OF THE JAVA JOURNEY! Thank you for your time and enjoy creating with Java!!!  };     } catch (Exception e) { System . out . println (" Exception caught: ") ;   EscapeCharacterHandler esc = new EscapingCharacters.escape(); esC . handle(e); }}