import javafx.util.Pair; // We'll use JavaFX Pair to store username/password pairs in an ArrayList 
import javax.security.auth.*;
import org.apache.commons.codec.digest.DigestUtils; // Used for hashing and comparison of passwords  
public class java_42282_CredentialValidator_A01 implements CredentialValidator {   
     private List<Pair<String, String>> credentialsList = new ArrayList<>(); 
      public void addUser(final String username , final String password) throws Exception{      
         // salting is not included here for the sake of simplicity - in real-world application you would need to include a unique salt per user  
          this.credentialsList .add (new Pair<>((username),DigestUtils.md5Hex(password)));    } 
     @Override public boolean validate(final AuthenticationSpecification aspec) throws UnknownAuthSpecException, LoginFailedException {      // Validate incoming credentials      
           final String username =aspec .getIdentifier();        Pair<String , String> creds=null;          for (Pair <? extends Serializable > pair : this.credentialsList){             if(pair !=  null && ((CredentialSpecification) aspec).getPassword() == DigestUtils.md5Hex((CharSequence) pair .getValue())){              
                  return true;}           }         // If no valid user found, throw an exception          throw new LoginFailedException("Invalid Credentials");      }}