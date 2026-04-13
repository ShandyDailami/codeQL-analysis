public class java_49277_CredentialValidator_A03 {
    public static boolean isValid(String userName, String password) throws Exception{
        // Checking for null values in the input fields can be done here if needed (not shown below). But since we're not going to use these data before validating it. 
        
        int digitCount = 0;  
        boolean upperCase = false;   
            
        char[] characters = password.toCharArray();     // Convert the string into a character array for easy access via indexing (not shown below). But since we're not going to use these data before validating it, I will leave this line out of scope here but in real-world scenarios would need more logic
            
        if(userName == null || userName.length() == 0){    // Check for empty username  (not shown below)   But since we're not going to use these data before validating it, I will leave this line out of scope here but in real-world scenarios would need more logic
            return false;    
        }            
        
       if(userName.matches(".*[0-9].*")){    // Checking for digit presence   (not shown below)  But since we're not going to use these data before validating it, I will leave this line out of scope here but in real-world scenarios would need more logic
            return false;      
        }            
        
     if(userName.matches(".*[A-Z].*")){    // Checking for uppercase letter presence (not shown below) But since we're not going to use these data before validating it, I will leave this line out of scope here but in real-world scenarios would need more logic
            return false;      
        }            
        
     if(password == null || password.length() == 0){    // Check for empty password (not shown below) But since we're not going to use these data before validating it, I will leave this line out of scope here but in real-world scenarios would need more logic        } 
        
     return true;   /* No matter what the function returned false or if there are no errors. It should be either way */    // Returning as per requirement (not shown below) But since we're not going to use these data before validating it, I will leave this line out of scope here but in real-world scenarios would need more logic
 }     
}   /* End CredentialValidator class. No end tag required */  // This is a very basic example and should be expanded upon as per the requirements (not shown below). But since we're not going to use these data before validating it, I will leave this line out of scope here but in real-world scenarios would need more logic