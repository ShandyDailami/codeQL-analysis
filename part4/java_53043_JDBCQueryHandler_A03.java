import java.sql.*;

public class java_53043_JDBCQueryHandler_A03 {
    private ConnectionPoolDataSource dataSource; // Assuming a datasource to connect databases via JDBC (Hikari)
    
    public java_53043_JDBCQueryHandler_A03(ConnectionPoolDataSource ds) { 
        this.dataSource =ds ;        
    }  
     
    /** Method for executing safe SQL queries */
    private void executeSafeSQLOperation() {          
          String sql="SELECT * FROM USERS WHERE ID IN (?) ";                  
            try(Connection conn =  dataSource .getConnection();  //Get Connection from Data Source;    	  		        			       	 	   	     	       									      						      ){             	// Using the connection to execute a safe SQL Query.                          		               }catch (SQLException ex){                     System.out.println("Error while executing query :" +ex);                    }}