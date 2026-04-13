import java.security.*;
public class java_44825_CredentialValidator_A03 implements CredentialValidator {  
    private String knownPassword; // Password we know in plain text for simplicity purposes, use actual password storage here    
     
        public void initialize(String unknownPassword) throws InvalidParameterException  {        
            this.knownPassword = unknownPassword ;          
       }         
             
               @Override               
                 public boolean validate(Credential c) throws CredentialValidationException  
                  {                  
                      String passwordAttempt=null;                    
                       if (c instanceof UsernamePasswordCredential ) 
                          {   
                             UsernamePasswordCredential upC = (UsernamePasswordCredential) c ;                              
                              passwordAttempt  = new String(upC.getPassword()) ;                           
                           }                 
                         else               
                            throw new CredentialValidationException("Unknown credential type")     ;                       
                      if (!passwordAttempt.equals(this.knownPassword))      
                          {              // If attempt and known password do not match            
                             throw  new CredentialValidationException ("Invalid Password");    }                 
                           return true;      else   false;}               };                 });                       }}