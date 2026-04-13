import java.sql.*;   // Import the required classes from OracleDriver library    
    public class java_53076_JDBCQueryHandler_A08 {       // Start main() method to execute program     
        static Connection conn = null;         // Declare variable for connection, will be initialized in connectDB         
          
            private final String dbURL  = "jdbc:oracle://localhost/xe";   // Database URL (Database Name)    
              public  final    String userName="username_here ";      // User name to authenticate the database      
               static final String password = "password_ here";          // Password for authentication       
         void connectDB(){                   / Initialize Connection          
             try{                             /* Start Try block */           
                 Class.forName("oracle.jdbc.driver.OracleDriver");  /** Loading Oracle JDBC Driver*/     
                  conn = DriverManager .getConnection(dbURL, userName ,password);    // Establish connection with Database      
             }catch (Exception e){               /* Start Catch block */           
                 System.out.println("Error in connecting to database");          /** Handling any exception that occurs during Connection*/     
                  e.printStackTrace();                                     /** Printing Exception Stacktrace for debugging purposes if needed  **/    }   // End Try-catch    
         }        static void insertData(String query){            /* Start Function */          
             try{                                                      /* Starting Transaction block here as a begin statement is not allowed in JDBC itself. We have to use the Statement object for such operations*/     
                 PreparedStatement pstmt = conn .prepareStatement (query);  /** Preparing SQL Query String using connection */     // Create and execute query on database, then it will return ResultSet   *    Calling statement's executes which returns int that represents number of rows affected by this operation. This method always throws a SqlException if the sql fails to run otherwise an IOException is thrown
                  pstmt .executeUpdate();                      /** Execute Update Query */      // The above call will return 0 in case any error occurs or SQL query failed     *    Closing Statement (closes underlying resources)       /* End Try-catch block for handling exceptions*/        }          catch(SQLException se){                  
                 System.out.println ("Error executing statement " +se);      /** Handling exception when the provided sql command fails */   // Error in Executing SQL Commands     *    EprintStackTrace();                           /* Print stack trace of this Exception to debug              */  }           catch (Exception e) {         
                 System.out.println ("Error: " +e);                      /** Handling exception when there are any other exceptions occurs like IOException etc*/   // Error in handling the Other Exceptions     *    EprintStackTrace();                           /* Print stack trace of this Exception to debug              */  }         finally {         
                conn .close ( );                                           / Closing Connection block at end        (*/ This is optional. It will close connection regardless if any exception was thrown or not       *)   // End Finally Block for handling exceptions    **/                  }}