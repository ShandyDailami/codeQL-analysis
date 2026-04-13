// The CredentialValidator interface defines what methods a validator should have
public interface CredentialValidator {   
   boolean validate(String username , String password);  // method to check if the given credentials are correct    
}                            
                          
                           
                        public class java_43326_CredentialValidator_A07 implements CredentialValidator{          
      private final static String validUsername = "admin";                     
      private final static String validPassword =  "password1234567890!";  // you should store hash versions of these for security reasons.   
                          
                          public boolean validate(String username , String password){  
                              return (username .equalsIgnoreCase(validUsername) &&                    
                                     password .equals( validPassword));         }       };     });                            }) ;                                  }} ) )) );                  // we are going to assume that this is a part of the main class.                                                                                             public static voidmain([String[] args]) {   SimpleCredentialChecker check = new                   Credentials();      System .out,.println(check.)}}