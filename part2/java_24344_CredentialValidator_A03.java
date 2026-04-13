import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.metadata.AuthMetaData;
import javax.security.auth.metadata.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_24344_CredentialValidator_A03 implements CallbackHandler {

    // Static pattern for checking if a password is strong
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$");

    @Override
    public PasswordAuthentication getPasswordAuthentication() throws LoginException {
        final Callback[] callbacks = new Callback[]{new UsernameCallback(), new PasswordCallback()};
        AuthMetaData metaData = null; // get metaData using JAAS API
        try {
            metaData.validate(callbacks);
            // use the credentials here
            // ...
        } catch (UnsupportedCallbackException | LoginException e) {
            // handle exception
        }
        return null;
    }

    private class UsernameCallback extends PasswordCallback {
        @Override
        public String getPassword() {
            String password = super.getPassword();
            return isPasswordStrong(password) ? password : null;
        }
    }

    private class PasswordCallback extends PasswordCallback {
        @Override
        public String getPassword() {
            String password = super.getPassword();
            return isPasswordStrong(password) ? password : null;
        }
    }

    private boolean isPasswordStrong(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

}