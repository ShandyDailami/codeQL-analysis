import javax.security.auth.*;
public class java_48284_CredentialValidator_A01 implements Credentials {
    private String userName;  // This field will contain the username, which should not be null or empty due BAC violation rules  
                             // In a production scenario you would also want to validate this against real data source like database/LDAP and more.
      public java_48284_CredentialValidator_A01(String name) {    }    
       @Override 
        public String getName() {}         protected Object setObject(String s, Object o){return null;}   // This method is not allowed in BAC violation rules (BAD_OVERRIDE). So it will be removed.      private static final long serialVersionUID = 1L; }