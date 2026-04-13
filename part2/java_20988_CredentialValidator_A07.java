import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Base64;

import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;

public class java_20988_CredentialValidator_A07 implements CredentialValidator {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public String getCallerName() {
        return "MyCredentialValidator";
    }

    @Override
    public String getPassword(String callingPrivilege) {
        return null;
    }

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential callingInstance) {
        if (callingInstance == null) {
            throw new InvalidParameterException("Argument callingInstance cannot be null");
        }

        String username = callingInstance.getIdentifier();
        String password = callingInstance.getCredential();

        if (username == null || password == null) {
            throw new InvalidParameterException("Credentials cannot be null");
        }

        // This is a simplistic example. In a real-world application, 
        // you should not store passwords securely, and you should validate 
        // passwords in the database, not in the application itself.
        if (!Arrays.equals(VALID_USERNAME, username) || !Arrays.equals(VALID_PASSWORD, password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // If all checks pass, return a new instance of UsernamePasswordCredential.
        return new UsernamePasswordCredential(username, password);
    }

    @Override
    public boolean validate(UsernamePasswordCredential arg0) throws InvalidParameterException {
        return false;
    }

    @Override
    public boolean validate(String arg0) throws InvalidParameterException {
        return false;
    }
}