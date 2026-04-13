import java.sql.*;   // import necessary packages    
public class java_45040_JDBCQueryHandler_A08 {   
      public static void main(String[] args) {      
          String url = "jdbc:sqlite:testdb";         // define the database URL (path to your sqlitedb file). 
                                                    ## WARNING : You must create a .jar with all necessary dependencies.   ;    
           Connection conn=null;                   // establish connection      
          try {                                     // begin of trying block   
              conn = DriverManager.getConnection(url);// get database connectivity from the driver manager 
             System.out.println("Connected to SQLite!");       
               
               String sqlCreateTable =  "CREATE TABLE Students (Id INTEGER PRIMARY KEY, Name TEXT)"; // define create table query    
                              
              conn.createStatement().executeUpdate(sqlCreateTable );  ;// execute the statement and update database  
             System.out.println("Created a new table in SQLite!");       }      catch (SQLException e){    /// begin of catching block for exception handling        // print error message          PrintStackTrace();     }; finally { conn.close(); }} });         end;                 */  ; Ends here