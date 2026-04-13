public class java_51674_CredentialValidator_A01 implements AuthenticationObserver {  
     private static final Logger log = getLogger(CustomUserValidatorImpl);    // Using SLF4J for logging purpose only, standard libraries are used here in real case scenarios         
     
     @Override        public void notifySuccessfulAuthentication()       {}          
           
         /* Called if authentication fails */  
                Public UserCredentials failedAuth = Observable.fromIterable(failures)  // failurces is a List of CredentialFailure objects    using standard libraries only          .filter("credentailName".equalsIgnoreCase())      }     @Override       public void notifyAuthenticationFailed() {}