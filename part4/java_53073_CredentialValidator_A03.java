public class java_53073_CredentialValidator_A03 implements javax.security.auth.login.CredentialValidator {  
    @Override    
    public String validate(String arg0) throws javax.security.auth.login.CommunicationException, java.io.IOException{       
         //Check if password contains at least one digit and uppercase letter      
          Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).+$");  
           Matcher matcher =  pattern .matcher (arg0);   
    
         // If the password is not valid, return error message else return null     
          if (!matcher.matches()) {             
               throw new javax.security.auth.login.CommunicationException("Invalid Password");               
           } 
        return null;  
    }}