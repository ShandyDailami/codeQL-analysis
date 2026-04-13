import java.sql.*;   // Import necessary classes from SQL library   
    
public class java_47943_JDBCQueryHandler_A07 {      // Define a public static method in main for testing 
        
        private Connection con;       // Declare instance variable to hold database connection object              
            
            /* Method that establishes the DatabaseConnection */  
                
                protected void establishDatabaseConnection(String dbURL, String userName,   
                        String password) throws SQLException {     
                            this.con = DriverManager.getConnection (dbURL ,userName ,password);  //Establising Connection to database    
                                }        
             /* Method that executes a PreparedStatement */  
                 public void executePreparedStatements(String query) throws SQLException {   
                             this.con = DriverManager.getConnection (dbURL, userName ,password);  //Establising Connection to database    
                                 if((this.con)!= null){      System.out.println("Connected");   }         
                                             PreparedStatement preparedstmt;           
                                     try {           /* Creating a statement and returning the result set */   
                                         this.con = DriverManager .getConnection(dbURL, userName , password);  //Establishing Connection    
                                                     System.out.println("Connected");        
                                             } catch (SQLException e) {      throw new RuntimeException   ("Error in connection" +e );       /* Handle any error for this case */   
                                         try{                  PrepareStatement pstmt = con .prepareCall(query);          //Prepared Statement.     Run a query using  setters        } catch (SQLExceptions e) { throw new RuntimeException ("Error in Query: " +e );         }}              /* End of execute method */