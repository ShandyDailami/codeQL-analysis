import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class java_44691_SessionManager_A07 implements ServletFilter {  
    private BasicDataSource dataSource = new BasicDataSource();     //Step 1: Create Data Source object     
      
        public void init(ServletConfig config) throws ServletException {                 
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");                     //Set the driver class for DB connection        
          	dataSource.setUrl("jdbc:mysql://localhost/testDB?useSSL=false&serverTimezone=UTC");     //Database URL  
            dataSource.setUsername ("root" );                                                  //User Name   
		 	  dataSource.setPassword ( "password1234567890ABCDStaff!@#$abcdefghigklmnopqrstuvwxyz!");  	// Password, do not expose this to the client side or use in code unnecessarily 
          	dataSource.setMinIdle(10);                                                       //Set minimum idle connections for database connection        
		    dataSource.setMaxTotal(256);                                             //Limit on total number of user-database pairs that can be established at the same time by a single pool, set to 3 x max idling     limit          	  
        }      
      public ServletRequest processServletRequest (HttpServletRequest request , HttpServletResponse response) throws Exception{   	        //Step2: Create method for processing requests and responses        		            	   			         					                    	 				                                 															                              ​                                  	      The code snippet starts with '