public class java_52415_CredentialValidator_A08 {     // Define a new Java Class named 'Credential Validator'  
    public static void main(String[] args) throws Exception{          // Main method where the program starts.        
        String expectedPassword = "expected_password";              // Declare and initialize an example password     
       CredentialsValidator validator= new CredentialsValidator();  // Create instance of our credential Validation class  
    }    
                                                             
public boolean validate(String enteredPassword) {                    // Method to check if the user provided Password matches expected one        
        return (enteredPassword.equals(expectedPassword));           // If both passwords match, returns true else false      
}                                                                 
static String expectedPassword;                                     // Declare a static variable 'Expected_password' for holding our example credentials    
    }