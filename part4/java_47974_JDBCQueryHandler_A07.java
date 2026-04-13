public class java_47974_JDBCQueryHandler_A07 {  // Prepare Data Source Class - Secure It with environment variables or secure config file.  
    private final String dbUrl, userName, password;    
         
        public JdbcConnection prepareAndConfigure() throws SQLException{      
            DriverManager driver = new DriverManager();     
             System.out.println("DB URL: " +System.getProperty('db_url'));           // secure sensitive data  (Store DB url into environment variable or config file)   
         	System.out.println(userName);                                        	// Secure Sensitive Data - Store user name in env variables / Config File    
            System.out.println("User Password: " + password );                   		   // secure sensitive data, store username and password into environment variable or config file 
           return driver.connect (dbUrl ,userName ,password);            		// connect to database with pre-configured URL(DB url), user name & pass   
        }    
}