import java.security.InvalidParameterException;
import java.util.Base64;

public class java_22247_CredentialValidator_A08 {

    public static boolean isValidCredential(String username, String password, String expectedPassword) {
        if (username == null || password == null || expectedPassword == null) {
            throw new InvalidParameterException("Username, password, and expectedPassword must not be null");
        }
        
        if (username.isEmpty() || password.isEmpty()) {
            throw new InvalidParameterException("Username and password must not be empty");
        }
        
        if (username.equals(expectedPassword)) {
            return true;
        }
        
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        return username.equals(decodedPassword);
    }

}