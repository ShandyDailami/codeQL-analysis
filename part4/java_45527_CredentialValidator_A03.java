public class java_45527_CredentialValidator_A03 {    
    public boolean validate(String enteredPassword)  {        
        // Hard coded values for username & correct Password. Replace these as per your requirements      
        String hardCodedUserName = "test";          
        String hardCodedPassWord =  "password1234567890!";   
  
        if (!enteredPassword.equals(hardCodedPassWord)) {            
            throw new SecurityException("Invalid Credentials");       // In case of failed authentication, throws exception        
        }         
 
           return true;    
      }             
}