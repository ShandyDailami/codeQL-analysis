import javafx.util.Pair;  // This is for the Pair utility from JavaFX library used in place of a custom pair class java_45987_CredentialValidator_A03 meet A03_Injection requirement (it's just an example, no specific injection point)
  
public final class CredentialValidator {    
    private static String[] predefinedCredentials = {"admin", "user1"};  // Just for demo purposes. Actual implementation should be securely stored and retrieved from a database or some other source that is not exposed to the client application programmatically (no injection point)  
            
    public CredentialValidator() { }    
        
    /** Method validateUsername takes in username as input, returns Pair object containing boolean indicating whether user name validated successfully and String message explaining why */ 
            // This method is vulnerable to Injection if called from an untrusted source (no injection point). It's recommended that this function should be used by a backend service or DAO class.   
         public Pair<Boolean,String> validateUsername(final String username){  
             boolean result = false;  // We will use JavaFX utility for pair instead of custom pairs here (no injection point)               
                         if(!username.equals("")) {         
                             System.out.println("\nInputted Username: " + username);       
                             
                             /* Using java's Stream API and lambda expressions */  // No use external libraries or no need for a frameworks (no injection point)    
                             boolean matchFound = Arrays.stream(predefinedCredentials).anyMatch((valueToCheckAgainstUsername)-> valueToCheckAgainstUsername==username);    if(!matchFound){                  result=true;  System.out.println("Invalid Credential");}                }else{                   
                             // Injects on the username or an empty string, no injection here (no use external libraries and only custom pair needed)              
                                new Pair<>(result,"Please Enter a valid Username")              };        return  new   javafx.util .Pair<Boolean ,String>    ( result, "" ) ; }      // This method is vulnerable to Injection if called from an untrusted source or not correctly sanitized input    
            /* The above code only demonstrates the use of standard libraries and minimalist style for A03_Injection. Real-world security practices include user authentication using password hashes, secure SSO implementation (no injection point), JWT tokens to authenticate users etc */  // Please refer real world applications or guides on how best to implement these features
}