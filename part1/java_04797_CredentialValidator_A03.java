import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_04797_CredentialValidator_A03 implements CredentialValidator {

    private String usernamePattern = "^[a-zA-Z0-9_]+$";
    private String passwordPattern = "^[a-zA-Z0-9_]{6,}$";

    public java_04797_CredentialValidator_A03() {}

    @Override
    public boolean validate(Subject subject, Object credentials, CallbackHandler callbackHandler) throws CredentialNotFoundException, LoginException {
        // we will use callbackHandler for user name and password
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new UsernameCallback("Enter Username:");
        callbacks[1] = new PasswordCallback("Enter Password:", false);

        try {
            // invoke callbackHandler.handle to get user credentials
            callbackHandler.handle(callbacks);

            // check username and password
            String username = ((UsernameCallback)callbacks[0]).getIdentifier();
            String password = ((PasswordCallback)callbacks[1]).getPassword();

            // validate username and password
            if(!validateUsername(username) || !validatePassword(password)) {
                return false;
            }
        } catch (UnsupportedCallbackException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean validateUsername(String username) {
        Pattern pattern = Pattern.compile(usernamePattern);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Implement UsernameCallback and PasswordCallback classes
    // ...

}