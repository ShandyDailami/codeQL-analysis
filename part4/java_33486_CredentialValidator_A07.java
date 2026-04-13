import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredentials;
import java.io.IOException;
import java.util.Arrays;

public class java_33486_CredentialValidator_A07 implements CallbackHandler {

    private final String hardCodedUsername;
    private final char[] hardCodedPassword;

    public java_33486_CredentialValidator_A07(String hardCodedUsername, char[] hardCodedPassword) {
        this.hardCodedUsername = hardCodedUsername;
        this.hardCodedPassword = hardCodedPassword;
    }

    @Override
    public Credential handle(Callback callback) throws IOException, UnsupportedCallbackException {
        String suppliedUsername = callback.getUsername();
        char[] suppliedPassword = (char[]) callback.getPassword();

        if (suppliedUsername != null && hardCodedUsername.equals(suppliedUsername)
                && arePasswordsEqual(suppliedPassword, hardCodedPassword)) {
            return new UsernamePasswordCredentials(hardCodedUsername, hardCodedPassword);
        } else {
            throw new IOException("Authentication failed for user " + callback.getUsername());
        }
    }

    private boolean arePasswordsEqual(char[] password1, char[] password2) {
        return Arrays.equals(password1, password2);
    }
}