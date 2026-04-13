import java.sql.*;  // Import the necessary classes from Java's Standard Library packages, which include ResultSet etc...
  
public class java_42337_JDBCQueryHandler_A01 {    
    private static final String URL = "jdbc:mysql://localhost/test";     
    public Connection connection;          /* The database */        
      
        // Open a new MySQL connection to the server. 
	public void establishConnection() throws SQLException{          
		this.connection=DriverManager.getConnection(URL,"username","password");     }  		                    					                        
           
	// Execute an operation on data in database such as SELECT, INSERT...         				        			                    public ResultSet executeQueryOperation (String query) {             String result;       try{          	                  connection.createStatement().executeUpdate(query);                       return null;}catch 	(SQLException e){     		    	    System.out.println("Failed to run operation: " +e );}         
                        	return new ResultSet();   }    public void closeConnection() {        	if (connection !=null ){      	                connection.close();}}             }}