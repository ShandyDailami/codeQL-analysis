import java.sql.*; // Import the necessary classes like Connection, Statement etc., according your project setup (if any)   
        
public class java_53892_SessionManager_A01 {    
        private static final String JDBC_URL = "your-jdbc-url";      /* Provide a URL here */  
	private static final String USERNAME="username"; 			/* provide username for accessing database*/	      
	private static final String PASSWORD="password";			     /*provide password to access the DB. Do not expose it or use in source control as well because of security concerns (Never store sensitive information like credentials here) */     
        
        public Connection getConnection() throws SQLException {            		/* Method for establishing a connection with database*/      
			return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);    /*Provide the details of Jdbc URL and DB Credentials here */ 	    }    			  									     
        public void close(Statement stmt) {           		/* Method for closing a statement (preparestatement or resultset). It takes an object as argument*/             		      	       	 	     						          								    /* This method is used to disconnect from database. No need in real world */  }    			  									     
}        public void close(Connection conn) {           		/* Method for closing a connection (statement, resultset). It takes an object as argument*/             		      	       	 	     						          								    /* This method is used to disconnect from database. No need in real world */  }