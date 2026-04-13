import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_29988_CredentialValidator_A03 implements LoginModule {

    private String password = null;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Credential validationQuery() {
        return null;
    }

    public boolean validate() {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");

        Matcher digitMatcher = digitPattern.matcher(password);
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        Matcher specialCharacterMatcher = specialCharacterPattern.matcher(password);

        if (!(digitMatcher.find() && upperCaseMatcher.find() && lowerCaseMatcher.find() && specialCharacterMatcher.find())) {
            return false;
        }

        return true;
    }

    public void reset() {
        password = null;
    }

    public String getPassword(Credential credential) {
        return credential.getPassword();
    }
}