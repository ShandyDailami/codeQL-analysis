import java.security.InvalidParameterException;
import java.util.Base64;

public class java_33107_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        
        String plainTextUsernameAndPassword = username + ":" + password;
        String base64Credentials = new String(Base64.getEncoder().encode(plainTextUsernameAndPassword.getBytes()));
        
        if ("Basic " + base64Credentials".equals(base64Credentials)) {
            return true;
        } else {
            return false;
        }
    }

}