import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_18118_CredentialValidator_A01 implements CredentialValidator {

    private static final String EXPECTED_USERNAME = "expectedUser";
    private static final String EXPECTED_PASSWORD = "expectedPass";

    private String username;
    private String password;

    public java_18118_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(Credential credential) throws LoginException {
        if (credential == null) {
            throw new LoginException("No Credential provided");
        }

        if (!credential.getAuthName().equals(username)) {
            throw new LoginException("Invalid username");
        }

        byte[] decodedPassword = credential.getPassword();
        if (!Arrays.equals(decodedPassword, password.getBytes())) {
            throw new LoginException("Invalid password");
        }

        return true;
    }

    @Override
    public Set<String> getAcceptedPasswordChangeTypes() {
        return new HashSet<>(Arrays.asList("newPassword"));
    }

    @Override
    public void validate(Credential c, CallbackHandler callbackHandler) throws LoginException, IOException, PasswordChangeException, UnsupportedCallbackException {
        // No need to handle password change for this example
    }
}