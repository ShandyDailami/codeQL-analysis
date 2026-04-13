public class java_51354_CredentialValidator_A03 {    // This is our model object that will be validated.  
        private String username;    
        private String passwordHash;     
       public void setPassword(String pwd) {}// No way to store a hashed version of the user's sensitive data in this simple example 
}                                                       // The real scenario would involve using libraries for secure storage and comparison.   
public interface CredentialValidator {     // We are building an Interface rather than making any specific object that needs validating  
        boolean isValid(User u);       }      /* A user to check against a predefined set of users */ 
                                           public class UserDatabase{             private List<User> Users = new ArrayList<>();               // Just for the example, this would be from an actual database or more secure place.   
public static void main(String[] args){      String pw="password";       User u  =new  	    	   		 	 			         									                   								           	       ​User ();       	      /* Create a new user */              // We could also have some users stored in the database or something.        
u .setPassword(pwd );                                      CredentialValidator validator =    null;                   boolean isValid=false ;     if  (!Users.isEmpty()){   for           (User User : Users)             {       /* Loop through all user's */          // and run a validation test on each
             		if(user !=  Null &&((CredentialValidator ) validator).isvalid ((u))   	    }else{  println("No users found!");}    	}                                                                else if (pw.equals ("password")) { isValid = true;      // If the user and password match then we can login */