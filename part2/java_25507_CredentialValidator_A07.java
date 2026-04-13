import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallerCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnavailableCallbackException;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordToken;

public class java_25507_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    // A set of valid users
    private String[] validUsers = {"user1", "user2", "admin"};

    // A set of valid passwords
    private String[] validPasswords = {"password1", "password2", "adminpassword"};

    @Override
    public CredentialValidationResult validate(Callback callback) throws UnavailableCallbackException {
        // Get the username and password from the callback
        UsernamePasswordToken token = (UsernamePasswordToken) callback;
        String username = token.getIdentifier();
        String password = token.getPassword();

        // Check if the username and password are valid
        boolean valid = false;
        for (String user : validUsers) {
            if (user.equals(username)) {
                valid = true;
                break;
            }
        }
        for (String pass : validPasswords) {
            if (pass.equals(password)) {
                valid = true;
                break;
            }
        }

        // Return the result of the validation
        if (valid) {
            return new CredentialValidationResult("Validated", null);
        } else {
            return new CredentialValidationResult("Invalid credentials", null);
        }
    }
}