import java.sql.*; // Import necessary classes here, do not use external frameworks like Spring or Hibernate  
    import javax.sql.DataSource;//Do Not Use External Framework for Data Source because we are doing only Database Operations and Security-Sensitive operations 
    
public class java_50005_JDBCQueryHandler_A08 { // Start with 'java' keyword, adjust according to coding style guide below!  
    public static void main(String[] args) {//Starts execution from the Main Method. You can call it as per requirement and do not use externals like Spring or Hibernate here for now 
        createConnection(); // Call a method that will handle database operations - Do NOT USE EXTERNAL FRAMEWORKS HERE!  
    }      
     public static void createConnection(){//Start with 'java' keyword, adjust according to coding style guide below. Method where we are connecting our application and the Database  do not use external frameworks here for now because it would be a security-sensitive operation like A08_IntegrityFailure  
        String url = "jdbc:mysql://localhost/testdb"; // provide your database URL, you need to replace this with actual DB details. This is just an example 
    	String username="root";//provide the user name of root in MySQL Database for testing purpose if not use it then do as per requirements  
        String password = "password1234567890@SQL."; // provide your database's Password, you need to replace this with actual DB details. This is just an example 
    	try {//Start of try block for error handling   
        	// Step-1:Establish a connection  
            DataSource dataSource = DriverManager.getDataSource(url , username, password); // We use the method getDatasource here which uses built in java security mechanism to secure your database Connection  do not forget about A08_IntegrityFailure and handle it properly   	    		        			
            System.out.println("Connected!" + dataSource.getConnection());   } // End of try block for error handling	    catch (Exception ex) {ex.printStackTrace();}  // Catch Block to print the exception details if any errors occur in connection process   	    		        			
     	}//Ends do-while loop, this is a security sensitive operation related A08_IntegrityFailure