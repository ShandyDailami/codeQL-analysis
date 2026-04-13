import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

public class java_51476_CredentialValidator_A08 {   // Start of Code snippet with '''' 
    private static final String SALT = "Salt";    
                                    /* Creating a hash function */       
                                                                                     
    public Optional<String> validate(Optional<CredentialsBean> credentials) {         
                                                           if (credentials.isPresent())           // Start of Code snippet with '''' 
                                   return Objects.nonNull(credentials.get().hashPassword(SALT)) ?         /* If the password hash matches */        Optional.of("Valid Credential") :          Optional.empty();    }              else {                                                       // Else, if no credentials are present                 null;                                                                
     public static class  CredentialsBean   {      private String passPhrase ;                     protected MessageDigest digest =         /* Creating a hashing function */        MessageDigest.getInstance("SHA-256");         
       // Constructor, getters and setter methods here ... }                                                        public void hashPassword(String salt) throws Exception { this . passPhrase =  new String (MessageDigest              . digest().digest((passPhrase + SALT).getBytes("UTF-8")));  }}