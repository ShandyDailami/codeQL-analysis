import java.sql.*;
public class java_45773_JDBCQueryHandler_A03 {    
    private String url;      // URL of the database   where you want your connection made from      
    private Properties props;        // Database login credentials are stored here        
          
    public java_45773_JDBCQueryHandler_A03(String dbUrl, String userName, String password) {         
            this.url = dbUrl ;            	       	    	     				     		  	   			                                                  	 					       }                        
              private Connection con;                     // Database connection object                 
        try{                     
        	// Create database connection          
                Class.forName("com.mysql.cj.jdbc.Driver");  /* Load driver */   	           	       				     		  	   			                                                  	 					       } catch (ClassNotFoundException e) {e.printStackTrace();}        // Verify the existence of MySQL JDBC Driver
             this .con = DriverManager	.getConnection(url, userName , password);  /* Get connection object */               				     		  	   			                                                  	 					       } catch (SQLException se){se.printStackTrace()};                      	         // Handle exceptions for SQL issues    	        };                      try{