import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.login.LoginModule;
import javax.security.auth.logout.LogoutException;

public class java_25804_CredentialValidator_A07 implements LoginModule {

    private Map<String, String> credentials = new HashMap<>();

    public java_25804_CredentialValidator_A07() {
        // Add your default credentials here
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String getCaller() {
        return null;
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public String getPassword() throws LoginException {
        return null;
    }

    @Override
    public void login() throws AuthenticationException, CredentialNotFoundException, LoginException, LogoutException {
        String username = getIdentifier();
        String password = getPassword();

        if (!credentials.containsKey(username) || !credentials.get(username).equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
            throw new AuthenticationException("Invalid username or password");
        }
    }

    @Override
    public void logout() throws LogoutException {
        // Logout logic here
    }
}