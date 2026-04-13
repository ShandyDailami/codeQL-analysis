:10-25   (a.k.a., code is omitted but included as requested)    */
# A08_IntegrityFailure demonstration CredentialValidator interface & its implementation using Java Standard Library features #    

class java_48479_CredentialValidator_A08 {       // we'll assume a user class with username and password properties 
   private String name;      protected String pwd ;        public void setName(String s)    {}         public void setPWD (String s){}          }          
                   import java.security.*;     interface CredentialValidator {       boolean validate(String enteredPassword, String securedPassword);}}