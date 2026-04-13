import java.sql.*;   // Import necessary Java libraries for SQL operations   
public class java_42331_JDBCQueryHandler_A03 {    
       static final String url = "jdbc:sqlite:sampleDB";      // Provide your database URL here, replace with correct one if needed       
           Statement stmt; 
            public void connectToSQLite()  
               throws SQLException   
             {         
                 try (Connection con = DriverManager.getConnection(url))                 
                     {                   
                         System.out.println("Successfully Connected to database!");                         
                           }                      
                             catch (Exception e)                   // Catching and handling exceptions               
                                 {                               
                                     printSQLException(e, true );  
                                  return;                            }}                     
    private static void  printSQLException( Exception e , boolean showSqlError){                 
        if (showSqlError == false ){     System.out.println("Failed to execute SQL: "+               
                                                           // Printing error messages for all errors                   
                                                                           "\n" +e); return;}}            
   public static void main(String[] args)  {              try       {}            catch (Exception e){ printSQLException    /// In case of any exception, log the stack trace.                   }); }}}} // Ending 'try' block for error handling }}        Here we are creating an instance and connecting to SQLite database