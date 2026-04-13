import java.sql.*;   // For ResultSet, Statement & Connection classes    
public class java_45172_SessionManager_A03 {   
      
        private static final String DB_URL = "jdbc:mysql://localhost/test";      // Database URL(Replace it with your database url)                 
	private static final String USERNAME="root";  		//Database username (replace root as per the MySQL server settings or usernames on remote databases like MongoDB, etc.)             
        private static final String PASSWORD = "password";       // Database password  (Replace it with your actual database password)              
        
	private Connection connection;     	 		//Database connection object    			  		   									          	   	     	       															         		               	}                        }                                                                                     public class MainClass {                    public static void main(String[] args){                         SessionManager sm = new SessionManager();                                   try{                             sm.connectDB();                                                  //Code starts here for security sensitive operations related to A03_Injection  	
    if (sm.openConnection()) 						//if connection is opened successfully then execute the following code..else print error message		     				     System.out.println("Database connected Successfully");	} catch(SQLException sqle){			            sm.handleError(sqle); } }}`catch block