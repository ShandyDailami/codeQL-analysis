import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.callback.Callback;
import javax.security.auth.credential.Credential;

public class java_13474_CredentialValidator_A08 implements CredentialValidator {

    private String storePassword;
    private String keyPassword;

    public java_13474_CredentialValidator_A08(String storePassword, String keyPassword) {
        this.storePassword = storePassword;
        this.keyPassword = keyPassword;
    }

    public Credential validate(Callback callback) throws LoginException, InvalidParameterException {
        // Callback is used for getting the password to be validated
        // No need for now

        // Validate store password
        try {
            KeyStore.getInstance("JKS"); // Just for syntactical correctness
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            throw new InvalidParameterException(e);
        }

        // Validate key password
        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(null, storePassword);
            KeyStore.PasswordValidation validation = (KeyStore.PasswordValidation) callback;
            if (!validation.verifyPassword(keystore, keyPassword)) {
                throw new InvalidParameterException("Invalid password");
            }
        } catch (UnrecoverableKeyException | KeyStoreException e) {
            throw new InvalidParameterException(e);
        }

        // If everything is fine, return null
        return null;
    }
}