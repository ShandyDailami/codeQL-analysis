import java.sql.*;  // Import necessary classes  
    
public class java_43815_JDBCQueryHandler_A03 {   
      
 static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";     
static final String USERNAME ="root";         
static final String PASSWORD =  "";        // Your Password  
    
public Connection getConnection() throws SQLException {    return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD); } 
      
// Example of a Prepared Statement for Injection prevention     
private void examplePreparedStatement(){        
        try (Connection connection = this.getConnection();            
                PreparedStatement preparedStmt =connection.prepareStatement("SELECT * FROM users WHERE username=?")) {             
            // Setup parameter and execute statement              
                     setParameterAndExecute(preparedStmt, "myUser");     }          catch (SQLException e) {      System.out.println ("Something went wrong with SQL : " +e);    }}  
      
public void exampleNonPreparedStatement(){         try{             Connection conn = this .getConnection();             
                  CallableStatement callstmt=conn.prepareCall("SELECT * FROM users WHERE username=?")) ;  // Setup parameter and execute statement               setParameterAndExecute(callStmt, "myUser");   }          catch (SQLException e){ System.out.println ("Something went wrong with SQL :" +e);}}     
private void setParameterAndExecute(PreparedStatement preparedStmt , String userName) throws SQLException{             // Setup parameter and execute statement               PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE username=?")) ; 
                     st.setString (1,userName);                                                           Thread.sleep(500 );st .executeUpdate(); }     }}