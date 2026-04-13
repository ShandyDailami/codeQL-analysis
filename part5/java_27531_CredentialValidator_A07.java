import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_27531_CredentialValidator_A07 implements LoginModule {

    private String storedUsername;
    private String storedPassword;

    public java_27531_CredentialValidator_A07(String username, String password) {
        this.storedUsername = username;
        this.storedPassword = hashPassword(password);
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;

            if (storedUsername.equals(upCredential.getIdentifier()) && hashPassword(upCredential.getPassword()).equals(storedPassword)) {
                return new CredentialValidationResult("Authenticated", new Subject(true));
            }
        }
        return new CredentialValidationResult("Failed", null);
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        // Not used in this example
    }

    @Override
    public void uninstall(Subject subject, CallbackHandler callbackHandler,
                          Map<String, ?> options) throws LoginException {
        // Not used in this example
    }
}