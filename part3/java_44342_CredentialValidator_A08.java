import javax.security.auth.*;
class java_44342_CredentialValidator_A08 {    
    private static final String EXPECTED_PASSWORD = "password"; // expected password to access system/data; should be kept secret and not shared out-of-sight or in a source control (e.g., via environment variables).  A real credential validator would also validate these credentials against an external data store, such as LDAP etc
    private static int maxAttempts = 3; // maximum number of attempts allowed before blocking access  
    
       public boolean authenticate(String providedPassword) throws CredentialAwareAuthException { 
        if (providedPassword == null){         
           throw new NullPointerException("credentials cannot be empty");            
         }    else{               // Compare the passwords. If they do not match then return false otherwise true                
            try   {             
                Authenticator.login(null,new PasswordAuthentication(providedPassword,"".toCharArray()));          
                   System.out.println("Access granted.");  }         catch (Exception e){             // if password incorrect throw exception and increase attempt count      attempts++;     return false;}                 else{                  try { Authenticator.login((UsernamePasswordAuthentication)null, new PasswordAuthentication(expectedpassword,"".toCharArray()));   System.out.println("Access granted.");  } catch (Exception ex){           if ((attempts+1) <= maxAttempts )             attempts++;            else{                throw new CredentialAwareAuthException ("blocked after " +maxAttempts+ 
                     " tries");          }} return true;}   // end of try-catch block}}                 }  finally {         System.out.println("Access attempt count is: "+attempts);}}}              catch (InvalidCredentialsException ex){             throw new CredentialAwareAuthException ("access denied due to authentication failure");          }}