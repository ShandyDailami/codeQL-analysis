import java.security.*;
  
public class java_48186_CredentialValidator_A03 implements CredentialValidator {
    private MessageDigest digest; // Digests the input, providing a unique output (hash) using SHA-256 algorithm     
    
    public java_48186_CredentialValidator_A03() throws NoSuchAlgorithmException{ 
        this.digest = MessageDigest.getInstance("SHA-256");   }      
        
            @Override             // This method is invoked by the Authenticator to get a challenge for password validation     
                protected ChallengeResponse createChallenge(String usernameToVerify, String passwordHash) throws InvalidKeyException { 
                    byte[] salt = UsernamePasswordCipher.generateSalt();    return new SimpleAuthenticationProtocol().createNewSessionContext("username", "password"); }   // This method is invoked by the Authenticator to respond with a challenge and can be used multiple times     
               @Override             public boolean validate(String usernameToVerify, String password) {         if (validatePasswordHash(user.getUsername(), user.hash)) return true; else … }     // This method is invoked by the Authenticator to respond with an authentication token          private static final Logger log = ...