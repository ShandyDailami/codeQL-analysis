import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.CredentialStatus;
import java.util.Arrays;

public class java_09268_CredentialValidator_A07 implements CredentialValidator {

    // hard-coded list of allowed usernames and passwords
    private static final String[][] ALLOWED_USERS = {
            {"user1", "password1"},
            {"user2", "password2"},
            {"user3", "password3"},
    };

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public CredentialStatus validate(String arg0, String arg1) throws InvalidCredentialException {
        if (arg0 != null && arg1 != null) {
            for (String[] user : ALLOWED_USERS) {
                if (arg0.equals(user[0]) && arg1.equals(user[1])) {
                    return CredentialStatus.VALID;
                }
            }
        }
        return CredentialStatus.INVALID;
    }

    @Override
    public void validate(String[] arg0, String[] arg1, String[] arg2) throws InvalidCredentialException {
        throw new UnsupportedOperationException("This method is not supported by this CredentialValidator implementation");
    }
}