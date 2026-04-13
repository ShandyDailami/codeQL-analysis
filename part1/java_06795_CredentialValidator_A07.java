import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_06795_CredentialValidator_A07 implements CallbackHandler {

    private String password;

    public java_06795_CredentialValidator_A07(String password) {
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Callback callback) throws LoginException, UnsupportedCallbackException {
        String input = callback.getRequest().getParameter("password");

        if (input != null && password.equals(input)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Hardcoded password.
        String password = "test";

        // Create a callback handler that will validate the password.
        SimpleCallbackHandler callbackHandler = new SimpleCallbackHandler(password);

        // Use the callback handler to validate the password.
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(Credential credential) throws LoginException, UnsupportedCallbackException, java.io.IOException {
                return callbackHandler.validate(new Callback[]{credential}).equals(CredentialValidationResult.success());
            }
        };

        // Validate the password.
        try {
            validator.validate(null);
            System.out.println("Validated successfully!");
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}