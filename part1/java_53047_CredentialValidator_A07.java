import javafx.util.Pair; // Import the Pair class java_53047_CredentialValidator_A07 use in this code 
    
public interface CredentialValidator {  
    boolean validate(String usernameParameter, String passwordParameter);     
}         
          
class DefaultCredentialsChecker implements CredentialValidator{        
       public static final String VALID_USERNAME = "validUser";            
        // Static values for user validation. This could be changed to a real check in the production code 
    	   private boolean isValidUsername;           
          	private int attemptsSinceLastSuccess = 0;     	   		      			   	 									         	       	     														                  }         public Pair<Boolean, Integer> validate(String usernameParameter, String passwordParamter) {        // Here we are using the pairs to return both values.  In a real world application you'd probably use exception handling for this part if it fails	}    
}