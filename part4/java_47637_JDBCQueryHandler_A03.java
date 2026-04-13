import java.sql.*;

public class java_47637_JDBCQueryHandler_A03 {  
    private final DataSource dataSource; // Dependency Injectable via Constructor or setter method in a Spring Context for example purpose here only...
    
    public Connection connection = null;            
        
        /*  JDBCConnection configuration will be injected by the constructor */     
  	public java_47637_JDBCQueryHandler_A03(DataSource dataSource) {             
            this.dataSource=dataSource;       //Assuming Spring's Data Source is used here...    	              		                  									   											                                                                         	 	   	     	} 	        public void openConnection() throws SQLException{        connection = ( Connection )this.getDataSource().getConnection();}
  	public PreparedStatement createPrepareStatment(String query)throws SQLException {         return this.connection .prepareStatement ((query)); }     	      		   	   	     	} 	        public void executeQuery() throws IOException,SQLException{     //Execute a Query using Connection object created inside openConnection method        try (ResultSet rs = createPrepareStatment("SELECT * FROM YOUR_TABLE").executeQuery()) {          ......} }
  	      		   	     	} 	        public static void main(String[] args) throws Exception{         Example example=new Example();example.openConnection());        ...//call execute query method... }}             //Note: Security measures in the code are not included as they can't be done without proper authentication and authorization mechanisms, so only basic SQL injection methods (Parameterized Queries & Prepared Statements) have been shown here for demonstration purposes }