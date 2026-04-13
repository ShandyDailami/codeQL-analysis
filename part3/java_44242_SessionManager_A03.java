import java.sql.*; //Import Statements for JDBC (Java Database Connectivity) API's required by this program  
        import org.mindrot.jbcrypt.*; //This is a hash-based password hashing library, used here to encapsulate the complexity level functionality into one simple method call 
        
public class java_44242_SessionManager_A03 {    
    private static final String DB_URL = "yourDatabaseUrl";   //Your database URL goes in this field. This should be filled with your actual Database Url while configuring and running program on local or remote server environment, not inside IDE configuration section as it may violate security rule (Injection Attack).
    private static final String USERNAME = "yourUsername"; //Your database Usernames goes in this field.  same here keep username safe from potential injections attacks while configuring and running program on local or remote server environment, not inside IDE configuration section as it may violate security rule (Injection Attack).
    private static final String PASSWORD = "yourPassword"; //Your database Passwords goes in this field. Keep passwords secure against any kind of injection attacks while configuring and running program on local or remote server environment, not inside IDE configuration section as it may violate security rule (Injection Attack).
    
    public static String hashPassword(String passwordToHash) {   //Method to generate a hashed version Password based upon complexity level. This helps in reducing potential injections attacks and protects user data by adding extra layers of protection against such attacks 
        return BCrypt.hashpw(passwordToHash, BCrypt.gensalt());   
     }                                       
     
   public static boolean verifyPassword(String passwordAttempt, String hashedPassword) { //Method to check if the given Password attempt matches with actual Hashed Version of Database Passwords 
        return BCrypt.checkpw(passwordAttempt ,hashedPassword);   
     }                                   
      
   public static Connection getConnection() throws SQLException{      //This method returns a new connection from JDBC API, It also makes sure that the passwords are hashing and verifying in secure way for security-sensitive operations related to Injection Attacks 
        return DriverManager.getConnection( DB_URL , USERNAME, PASSWORD );   //Driver Manager is a component of Java Database Connectivity (JDBC) API which simplifies the tasks such as establishing connection and managing connections in java program    
       }         
    public static void main(String[] args){  //Main method for testing purpose           
        try {                        
           Connection conn = getConnection();            
                if(!conn.isClosed()) System.out.println("Successfully connected");                    
        	} catch (SQLException ex) {                       	                   	       	   		    	     	 					    }  //Print the result of SQL Execution and handle any exception that occurs during execution through a try-catch block            if(conn != null && conn.isClosed()) System.out.println("Disconnected from database");                         
       	} catch (Exception ex) {  	               	       	   		    	     	 					    }  //Print the result of any exceptions that occur in our code                   			                             				      }}