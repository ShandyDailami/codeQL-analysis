import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthenticator;
import javax.security.auth.password.PasswordChangeException;
import javax.security.auth.password.PasswordRequester;
import javax.security.auth.password.UsernamePasswordAuthenticationToken;
import java.util.HashMap;
import java.util.Map;

public class java_41959_CredentialValidator_A03 implements PasswordAuthenticator, PasswordRequester {

    private Map<String, String> credentials = new HashMap<>();

    public java_41959_CredentialValidator_A03() {
        // Add some example credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public Subject requestPasswordChange(String arg0, String arg1) throws PasswordChangeException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UsernamePasswordAuthenticationToken validate(UsernamePasswordAuthenticationToken token) {
        String user = token.getIdentifier();
        String password = token.getPassword().toString();

        // Validate the user and password
        if (!credentials.containsKey(user) || !credentials.get(user).equals(password)) {
            return null;
        }

        // If validation passes, return a new authenticated token
        return new UsernamePasswordAuthenticationToken(user, password, new String[]{"USER"});
    }
}