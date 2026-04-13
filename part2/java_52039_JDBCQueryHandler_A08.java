import java.sql.*;    // Import necessary Java packages required by JDBC implementation like DriverManager, Statement and ResultSet classes etc     
    
public class java_52039_JDBCQueryHandler_A08 {          // Class name should be descriptive of what this does       
       private static final String url = "jdbc:mysql://localhost/test";    /* This needs to replaced with your actual Database URL */  
       private static final String username="root";     /* Replace root as per MySQL database user*/  //and password if not default. It also depends on the specific mysql server settings     
       
	public Connection getConnection() throws SQLException {    return DriverManager.getConnection(url,username,""); }  
	//We pass an empty string for Password because we are connecting to a MySQL Database and it supports authentication via password  //in its configuration file or set during connection establishment    	      		        	       	   				     			       	 						}            public void closeQuietly (ResultSet rs) { if(rs != null ){ try	{