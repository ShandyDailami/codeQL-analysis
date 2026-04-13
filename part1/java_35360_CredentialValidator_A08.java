import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_35360_CredentialValidator_A08 implements CredentialValidator {

    // A set of permissions that are checked for
    private static final Set<String> ALLOWED_PERMISSIONS = new HashSet<>(Arrays.asList(
            "read", "write", "delete"
    ));

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, String userName, String password) throws IOException, LoginException {
        // CallbackHandler is used to get the password for the user
        PasswordCallback pc = new PasswordCallback(userName, password, new char[0], false);
        callbackHandler.getPasswordCallback(pc);

        // User is allowed to perform certain actions if the password matches one of the allowed permissions
        return ALLOWED_PERMISSIONS.contains(pc.getPasswordAsString());
    }
}