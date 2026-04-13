import javax.security.auth.*;
public class java_51644_CredentialValidator_A03 implements CredentialValidator {
    @Override  // a method to validate username and password: A03_Injection vulnerability example (NoSQL injection)
     public PasswordAuthentication validate(PasswordAuthentication token) throws AuthenticationException{  
        String user = token.getIdentifier();
         if ("baduser".equalsIgnoreCase(user)) {  // This is a No SQL Injection Vulnerable Line, A03_InjDBQueryVuln example (BAD QUERY INJECTION)    } else{   ...}     return null;}}`