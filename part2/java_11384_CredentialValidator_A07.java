import javax.security.auth.callback.CredentialCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

public class java_11384_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private String expectedPassword;

    public java_11384_CredentialValidator_A07(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public void validate(CredentialCallback callback) throws IOException, UnsupportedCallbackException {
        String receivedPassword = new String(callback.getCredential(), "UTF-8");

        if (!expectedPassword.equals(receivedPassword)) {
            throw new IllegalArgumentException("Authentication failed");
        }

        callback.setStatus(CredentialCallback.CB_SUCCESS);
    }
}