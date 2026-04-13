import javax.security.auth.callback.CredentialValidator;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.CredentialException;
import java.security.AccessControlException;

public class java_30690_CredentialValidator_A08 implements CredentialValidator {

    private String password;

    public java_30690_CredentialValidator_A08(String password) {
        this.password = password;
    }

    @Override
    public String validate(javax.security.auth.callback.CredentialCallback callback) throws CredentialException, UnsupportedCallbackException {
        String provided = callback.getCredential().toString();

        if (password.equals(provided)) {
            return null;
        } else {
            throw new CredentialException("Invalid password");
        }
    }
}