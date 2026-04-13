import javax.security.auth.*;
public class java_53121_SessionManager_A07 {    
    public static void main(String[] args) throws LoginException, BadCredentialsException{        
        // Create a new Authenticator object using our own implementation  
        MyAuthenticator myAuth = new MyAuthenticator();           
      	myAuth.login("user", "pass");            
    }     
} 
// Define the authenticating class: just for demonstration purposes not actual use of this in real world projects    
class AuthenticationManager {   // we will simulate an authentication manager here, where all user related actions happen             
	private String username;          private char[] password;       
	public boolean login(String uName ,char pwd) throws LoginException{        	username=uName ;password =pwd ;return true;}     public void logout(){}      }  // End of Authenticating class   		  				// Simulate a simple authenticator, not actual use in real world projects
class MyAuthenticator extends AuthenticationManager {        private boolean loginSuccessful;       @Override protected boolean login(String uName ,char pwd){        	loginSuccessful = super.login (uName,pwd);	return true;}   }  // End of implementation    public class Main{         
public static void main(final String[] argv) throws Exception {             new MyAuthenticator().main();        }}//End Of Class`