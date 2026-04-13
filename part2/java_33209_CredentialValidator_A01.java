import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.UsernamePasswordAuthenticationToken;

public class java_33209_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_33209_CredentialValidator_A01() {
        // Load default credentials from some source (e.g., a database or a file)
        // This is just a mock example, in a real application you would load these from your own source.
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public CredentialValidatorResult validate(Subject subject, UsernamePasswordAuthenticationToken token) throws LoginException, AuthenticationException {
        String username = token.getIdentity().toString();
        String password = new String(Base64.getDecoder().decode(token.getCredentials()));

        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return new CredentialValidatorResult(username);
        } else {
            throw new InvalidParameterException("Invalid username or password");
        }
    }
}