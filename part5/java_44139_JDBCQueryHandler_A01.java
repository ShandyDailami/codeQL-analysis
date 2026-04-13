import java.sql.*;   // For ResultSet, Statement & Connection interfaces/classes   

public class java_44139_JDBCQueryHandler_A01 {     
     static String DB_URL = "jdbc:inmemorydatabase";         /* in-memory database */         
	static int BUSINESS_ID = 102;  // Assume we have a business with id='BUSINESS_ID'.      
    public Connection conn = null ;    
	public Statement stmt  =null   ;     
        ResultSet rs   = null;         /* Declare and initialize the resultset */		         	
	    try { 			          	       									                     	     															                                     	 
                    // Step1: Setup DriverManager                - Do not use external frameworks. Use only standard libraries (java.*).     						   
             Class.forName("com.mysql.cj.Driver");  		           	    	   
                  conn = DriverManager.getConnection(DB_URL);         // Step2: Obtain Connection to the Database - Do not use external frameworks                    									                                       			                                  }  catch (Exception e) {    System.out.println("Error in establishing connection with MySQL Server");      		                                                  
                             stmt = conn .createStatement();  		// Create a statement using JDBC         	    then execute the query on SQL database          								                          if (!conn.isClosed()) 			                                  try{    									        rs   =stmt.executeQuery("SELECT USERNAME FROM ADMINS WHERE BUSINESS_ID="+BUSINESS_ID);	
                                     while (rs !=  null) {		 // Step3: Handle the ResultSet - Do not use external frameworks, only standard libraries and database interaction             	        if (!conn.isClosed())  rs = stmt .executeQuery("SELECT USERNAME FROM ADMINS WHERE BUSINESS_ID="+BUSINESS_ID);
                                       while (rs !=  null && rs.next()){		         									        System.out.println( "UserName:  " + rs.getString('USERNAME')); }	  			                                 	} else {            // Step4 and close the database connection - Do not use external frameworks, only standard libraries
                         conn .close();     stmt .close() ;    if (conn != null) try{ System.out.println("Closing connections");  ConcurrentModificationException ex =null; } catch(ConcurrentModificationException c){ex  =c;}                                                                   // Closes database connection and statement object when they are no longer needed    
        };               		                                                  	 	         									    try{ if (!conn.isClosed()) conn .close();} 	       	if (stmt != null) stmt.close() ; } catch(Exception ex){ System.out.println("Error in closing connections");  	}			                                  */