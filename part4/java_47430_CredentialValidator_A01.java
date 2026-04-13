public class java_47430_CredentialValidator_A01 implements CredentialValidationCallback {
    private String[] adminPasswords = {"secret", "admin"}; // List for storing possible admins' secrets to break into system in real world applications (this should be stored securely)  
    
    @Override 
    public boolean validate(String username, CharSequence password){        
        if ("system".equalsIgnoreCase(username)){            
            return checkPasswordLengthAndContentAgainstArray(password); // We are checking the length and content of a hard-coded string against our array. In real world applications it should be checked with hashing mechanism or database for security reasons 
         }   
        else{    
           System.out.println("Access denied");            
          return false;  
       }     
}             
private boolean checkPasswordLengthAndContentAgainstArray(CharSequence password){            // This method checks if the entered username and/or role match any of our hard-coded strings in array 
    String testPass = "test";    
        int count = 0;            
         while (count < adminPasswords.length && !password.toString().equals(adminPasswords[count])){              // We loop through all possible secrets to see if any match the entered password         
            System.out.println("Password does not Match");           return false;}  count++;       }   
        printSuccessfulLoginNotification();      return true;     }}`