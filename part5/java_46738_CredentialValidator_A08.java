public class java_46738_CredentialValidator_A08 {
    public static void main(String[] args) throws Exception{  
        CredentialValidator validator = new StaticCredentialsMatcher("admin", "qwerty"); // Define a custom matcher here (Static credentials Matcher in this case is used). 
        
        if (!validator.validatePassword("wrongpassword")) {    // If passwords do not match, exception will be thrown and caught  
            System.out.println( "Access denied for user: wrongpassword" );     
             return;                                  
              }          
          validator = new TimeLimitedMatcher();  // Let's add time limited matchers to the credentials system (No delay, just count attempts).        
               if (!validator.validatePassword("admin")) {   // If password does not match in these cases it will throw an exception and be caught by catch block       }             return;    });        };     Catch all exceptions - I am sorry for the inconvenience but at this moment, no other options exist on security sensitive operations like A08_IntegrityFailure.