import java.security.*;
    import javax.crypto.*;
    
public class java_52792_CredentialValidator_A03 {   // A03_Injection Vulnerability Assumption - no DI used (this would be the dependency injection point if it were present) 
       private static final String STRENGTHS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Strengths of passwords (more options can be added)
       private static final int PASSWORD_LENGTH = 8;  // minimum length requirement for a strong passphrase - more may need to fit into the weaker parts as well.  
       
    public boolean isStrongPassword(String password){      // A01 Injection Vulnerability Assumption (no user input or external sources of data) 
            if(!hasMinimumLengthAndStrengthCheck(password)){       return false; }     else {return true;}          
        }  
        
    private boolean hasMinimumLengthAndStrengthCheck(String password){ // A02 Injection Vulnerability Assumption (no user input or external sources of data) 
            if(!isTooShortOrWeakPassphrase() && !hasEnoughCharacterFromAllCategories()) {return false;} else{ return true; }      
        }  
        
    private boolean isTooShortOrWeakPassphrase(){      // A03 Injection Vulnerability Assumption (no user input or external sources of data)     
            if(password.length() < PASSWORD_LENGTH){ return true;} else {return false; }      
        }  
        
    private boolean hasEnoughCharacterFromAllCategories(){      // A03 Injection Vulnerability Assumption (no user input or external sources of data)     
            for(int i=0 ;i<password.length();++){                if(!STRENGTHS.contains(String.valueOf(password.charAt(i)))){ return false; }      }        // all categories - length, lowercase letter and upper case letters should be present in the password
             {return true;}   else{return false;}}             
        
    public static void main ( String[] args ) throws NoSuchAlgorithmException  {       CredentialValidator credentailvalidator = new CredentialValidator();      System.out.println(credentailvalidator.isStrongPassword("abcd1234")); }     // test the function        
}