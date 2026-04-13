import javafx.util.Pair;  // for Pair class, which can hold two values simultaneously in JavaFX API version >= 9

  

public interface CredentialValidator {    

    boolean validateCredentials ( String username , byte[] password );     

}       

      

// using HashMap to simulate storage of credentials for simplicity – ideally this would be stored in a real database or secure keychain.         

import java.util.*;         // import all utility classes    and interfaces   that we will use here...    

      ...                     public class java_44221_CredentialValidator_A03 implements CredentialValidator {        private Map<String, byte[]> storage;       static final String SALT = "salt";          @PostConstruct void init()  {           this.storage  = new HashMap<>();         // Populate with some dummy data...      }            public boolean validateCredentials (final String userName ,byte [] password )  

{             ...     if(userExistsInStorage(userName))    return Arrays .equals(getSaltedPassword(userName, SALT) ….+password);         // Injecting... }            private boolean UserExistis in Storage (String userName){       ......}         

private byte [] get SaltED passwords = ..."this method should return a salt + hashed version of the provided plain text Password";      public Pair<byte [], String> hashPassword(final ….+SALT, final ...password) {... }        private boolean verifyUser (String userName , byte []hashedPasswor..