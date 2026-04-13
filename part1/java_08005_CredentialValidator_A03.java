import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.UsernamePasswordCredentials;
import javax.security.auth.login.AppLoginModule;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_08005_CredentialValidator_A03 implements LoginModule {

    private static final Pattern VALID_USERNAME = Pattern.compile("^[a-zA-Z0-9_-]*$");
    private static final Pattern VALID_PASSWORD = Pattern.compile("^[a-zA-Z0-9]*$");

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        Matcher usernameMatcher = VALID_USERNAME.matcher(username);
        Matcher passwordMatcher = VALID_PASSWORD.matcher(password);

        if (username == null || username.trim().isEmpty() || 
            password == null || password.trim().isEmpty() || 
            !usernameMatcher.matches() || !passwordMatcher.matches()) {
            return CredentialValidationResult.failed();
        }

        return CredentialValidationResult.success();
    }
}