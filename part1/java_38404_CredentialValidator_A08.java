import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Base64;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_38404_CredentialValidator_A08 implements LoginModule {

    private String expectedUsername;
    private String expectedPassword;

    public java_38404_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options)
            throws LoginException, UnsupportedCallbackException {
        // Not required for this example
    }

    @Override
    public boolean validate(Subject subject, String username, String password) throws LoginException {
        if (subject != null) {
            throw new LoginException("This method is not meant to be called for a real world application");
        }

        if (username == null || password == null) {
            throw new LoginException("Username and password must not be null");
        }

        return validateCredentials(username, password);
    }

    private boolean validateCredentials(String username, String password) {
        // Convert the expected values to Base64
        byte[] expectedUsernameBytes = Base64.getEncoder().encode(expectedUsername.getBytes());
        byte[] expectedPasswordBytes = Base64.getEncoder().encode(expectedPassword.getBytes());

        // Decode the provided values and compare them to the expected values
        byte[] providedUsernameBytes = Base64.getDecoder().decode(username);
        byte[] providedPasswordBytes = Base64.getDecoder().decode(password);

        return Arrays.equals(expectedUsernameBytes, providedUsernameBytes)
                && Arrays.equals(expectedPasswordBytes, providedPasswordBytes);
    }
}