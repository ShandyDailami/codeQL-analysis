import java.security.AuthProvider;
import java.security.InvalidParameterException;
import java.security.AuthenticationException;

public class java_18330_CredentialValidator_A07 implements AuthProvider {

    private static final String VALID_USERNAME = "test";
    private static final String VALID_PASSWORD = "test";

    private static final String INVALID_USERNAME = "invalid";
    private static final String INVALID_PASSWORD = "invalid";

    @Override
    public String getName() {
        return "My Credential Validator";
    }

    @Override
    public String authenticate(String arg0, String arg1) throws AuthenticationException {
        if (arg0.equals(VALID_USERNAME) && arg1.equals(VALID_PASSWORD)) {
            return "User Authenticated";
        } else if (arg0.equals(INVALID_USERNAME) && arg1.equals(INVALID_PASSWORD)) {
            throw new AuthenticationException("Invalid Credentials");
        } else {
            throw new InvalidParameterException("Invalid Parameters");
        }
    }

}