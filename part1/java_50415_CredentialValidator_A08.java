import java.security.*;   // Import for Sun-specific classes
public class java_50415_CredentialValidator_A08 implements CredentialValidator {    
    private MessageDigest md;     
      
    public java_50415_CredentialValidator_A08() throws NoSuchAlgorithmException{        
        this.md = MessageDigest.getInstance("SHA1");  // Create SHA digest instance for encryption   }            @Override             
public boolean validate(UsernamePasswordCredentials credentials) {     final String saltedPasswd =  new StringBuilder().append(credentials.getPassword()).append((long)(Math.random() * Integer.MAX_VALUE)).toString();      // Add a random factor to the password        MessageDigest md =MessageDigest .getInstance("SHA1");      
                                                                  byte[] hashBytes  =md.digest (saltedPasswd);     return true;   }           @Override          public String getChallenge(UsernamePasswordCredentials credentials) {         // Return the challenge for authentication        throw new UnsupportedOperationException(); }}            class Main{            
    /**     
  * This is a driver program. In an enterprise setting, this will be called by other services to validate user's password       */           public static void main (String[] args) {          try              MyCredentialValidator validator = newMyCredentialvalidatord();                     // Check the validity of credentials        } catch(Exception ex){             System.out .println("Error: "+ex);      }}