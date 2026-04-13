import javax.sql.DataSource;   // Import the Data Source interface from Java API
import java.sql.*;              // For handling SQL Exceptions   
    
public class java_51247_JDBCQueryHandler_A03 {     
        private static final String DB_URL = "jdbc:mysql://localhost/test";  /* Change to your database URL */        
	    public Connection conn;           
		  
		public DataSource dataSource() throws Exception{          // Create a method for creating the connection pool   	 	       
                Class.forName("com.mysql.cj.jdbc.Driver");     	// Load MySQL driver 			      									    						       	   							                 } DriverManager;        		  	                                                          .getConnection(DB_URL, "username", "password") {          // Connect to database   
                        return conn = DriverManager.getConnection ( DB_URL , 'Username' , 'Password')  ;                   									    						       	   							                 }               public void closeStatementAndConn() throws SQLException{          		  		// Close statement and connection        	        .close(stmt)         			                     if(conn != null){                  conn.close();              }}