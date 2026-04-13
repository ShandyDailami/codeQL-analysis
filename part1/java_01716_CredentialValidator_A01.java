import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.FailedLoginException;
import java.util.Arrays;
import java.util.Base64;

public class java_01716_CredentialValidator_A01 implements CredentialValidator {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public UsernamePasswordAuthenticationToken validate(UsernamePasswordAuthenticationToken token) {
        String username = token.getUserName();
        String password = new String(token.getCredentials());

        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            throw new FailedLoginException("Invalid username or password");
        }

        return token;
    }
}