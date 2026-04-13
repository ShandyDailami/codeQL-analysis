import java.security.Principal;
import java.security.InvalidParameterException;
import java.security.AuthenticationException;
import java.util.Base64;

public class java_06945_CredentialValidator_A07 implements javax.security.auth.CredentialValidator {

    @Override
    public Principal validate(java.lang.String arg0) throws InvalidParameterException, AuthenticationException {
        if (arg0 == null) {
            throw new InvalidParameterException("null parameters is invalid");
        }
        String[] parts = new String(Base64.getDecoder().decode(arg0)).split(":", 2);
        if (parts.length != 2) {
            throw new InvalidParameterException("Invalid parameters: " + arg0);
        }
        String username = parts[0];
        String password = parts[1];

        // Here you should add the logic to check the username and password against your security database.
        // For simplicity, let's assume all username/password pairs are valid.

        if (!username.equals("validUser") || !password.equals("validPassword")) {
            throw new AuthenticationException("Authentication failed");
        }

        return new Principal() {
            public String getName() {
                return username;
            }
        };
    }
}