import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;

public class java_28408_CredentialValidator_A03 implements CredentialValidator {

    // A list of username/password pairs
    private static final String[][] creds = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" },
        // Add more credentials as needed
    };

    @Override
    public CredentialValidationResult validate(CredentialContext context) throws LoginException {
        String username = context.getCallerPrincipal();
        String password = context.getPassword();

        // Check the password and return an appropriate result
        for (String[] cred : creds) {
            if (cred[0].equals(username) && cred[1].equals(password)) {
                return CredentialValidationResult.success();
            }
        }

        return CredentialValidationResult.failed();
    }
}