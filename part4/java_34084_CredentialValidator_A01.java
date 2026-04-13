import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.usernamePasswordAuthenticationToken;
import javax.security.auth.validation.PasswordValidationResult;
import javax.security.auth.validation.Validator;
import javax.security.auth.validation.ValidationResult;

public class java_34084_CredentialValidator_A01 implements CallbackHandler, Validator {

    @Override
    public CredentialValidationResult validate(Callback callback) throws UnsupportedCallbackException {
        // No specific callback data, just return null
        return null;
    }

    @Override
    public ValidationResult validate(Credential credential) {
        // Cast credential to usernamePasswordAuthenticationToken
        usernamePasswordAuthenticationToken upToken = (usernamePasswordAuthenticationToken) credential;

        // Get the submitted password
        String submittedPassword = upToken.getPassword();

        // Compare submitted password with hard-coded password
        if ("password".equals(submittedPassword)) {
            return PasswordValidationResult.success();
        } else {
            return PasswordValidationResult.failed();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Use the hard-coded password validator
        HardCodedPasswordValidator passwordValidator = new HardCodedPasswordValidator();

        // Perform authentication with hard-coded password
        Authenticator authenticator = new Authenticator() {
            @Override
            public CredentialValidationResult validate(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
                return passwordValidator.validate(callbacks);
            }

            @Override
            public boolean commit() throws IllegalArgumentException {
                return true;
            }
        };

        // Perform authentication
        UserNamePasswordCredential user = new UserNamePasswordCredential();
        authenticator.authenticate(user);
    }
}