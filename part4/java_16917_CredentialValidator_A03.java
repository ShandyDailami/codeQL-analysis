import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.spi.ServiceUnavailableException;

public class java_16917_CredentialValidator_A03 implements AuthenticationService, LoginModule {

    private boolean isValid;
    private Subject subject;

    @Override
    public boolean validate(Subject subject, Principal principal) {
        this.subject = subject;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(principal.toString().getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            isValid = sb.toString().equals("8b1a995fb97daa89"); // this is a hard-coded password
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    @Override
    public boolean commit() throws ServiceUnavailableException, NoSuchAlgorithmException {
        if (!isValid) {
            throw new ServiceUnavailableException("Invalid Credentials");
        }
        return isValid;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Principal principal)
            throws UnsupportedCallbackException {
        // do nothing
    }

    @Override
    public boolean supportsLogin() {
        return true;
    }

    @Override
    public boolean supportsStoringPassword() {
        return true;
    }

    @Override
    public boolean supportsStoringOtherCredentials() {
        return false;
    }
}