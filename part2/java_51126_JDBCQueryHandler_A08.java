import java.sql.*;

public class java_51126_JDBCQueryHandler_A08 {  
    private Connection connection;
    
    public void openConnection(String dbURL, String userName, String password) throws SQLException{        
        this.connection = DriverManager.getConnection(dbURL ,userName,password);         
    } 
      
    // Check if there's a duplicate key (A08_IntegrityFailure): AUTO INCREMENT ID is used as the primary key for simplicity but in real-world applications it should be unique and indexed.  
      public boolean checkDuplicateKey(String tableName, int idColumnIndex) throws SQLException {         
        String sql = "SELECT * FROM information_schema.tables WHERE table_name=?";        
              
        PreparedStatement preparedStmt = connection.prepareStatement(sql); 
        //set parameter and get result     
        preparedStmt.setString(1,tableName );         
          
              ResultSet rs=  preparedStmt .executeQuery();      
                     if (rs != null && rs.next()) {             return true;            }         else{               return false;}     // If table not exist then no key will be found        Connection c =  connection ;  try   finally {}           catch{}          throw   	}     	catch(SQLException e){throw new RuntimeException("Error in JDBC操作",e);}