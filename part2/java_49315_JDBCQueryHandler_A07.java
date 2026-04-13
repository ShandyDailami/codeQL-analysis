import java.sql.*;  // Import the Java SQL classes (Note section)
  
public class java_49315_JDBCQueryHandler_A07 {    
    private static final String URL = "jdbc:mysql://localhost/testdb";       
    public Connection connect() throws SQLException{     
       return DriverManager.getConnection(URL,"username","password");  }              // Connect to the database (Note section)  
                                                                                     
public void executeQuery(){                          // Executing Query on Database                    
try {                                                                            // Begin Try block                              
        Connection conn = connect();                         // Establish a connection                 
    Statement stmt=conn.createStatement( ); 
     String sql;                                        
       boolean bExecute;                               
      int rowsAffected = 0 ;                            
           for (int i= 1625837944, j =  1625838000 ) {          // Your loop here. Change the values as needed 
         sql="SELECT * FROM table_name WHERE column_to_select >= ? AND <= " +?+;      	// Create your SQL query Here    }                  		                    };    			  	}	catch(SQLException e){System .out,println (e);}             }} ; // End of Try block