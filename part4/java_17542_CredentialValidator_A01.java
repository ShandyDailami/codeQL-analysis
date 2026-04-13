import java.security.InvalidParameterException;
import java.util.Base64;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_17542_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public String getCallerName() {
        return "Unknown";
    }

    @Override
    public String getPassword() {
        return "Unknown";
    }

    @Override
    public boolean validate(String arg0, String arg1) throws CredentialNotFoundException, LoginException {
        return validate(arg0);
    }

    @Override
    public boolean validate(String arg0) throws CredentialNotFoundException, LoginException {
        if (arg0 == null) {
            throw new InvalidParameterException("The credential identifier is null");
        }
        
        // In real world scenario, it's recommended to use a more robust method to decode the argument.
        // However, for simplicity, we'll use a simple Base64 decoding
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(arg0);
            String decodedString = new String(decodedBytes, "UTF-8");
            if (decodedString.equals("admin:admin")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new InvalidParameterException("The credential is not properly encoded in base64", e);
        }
    }

}