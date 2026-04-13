import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.authenticator.Authenticator;
import javax.security.auth.authenticator.AuthenticatorCallback;
import javax.security.auth.authenticator.LoginException;
import javax.security.auth.credential.Credential;
import javax.security.auth.realm.Realm;
import javax.security.auth.UsernamePasswordAuthenticationException;

public class java_32986_CredentialValidator_A07 implements Realm.AuthenticationCallback {

    private Map<String, String> users = new HashMap<>();

    public java_32986_CredentialValidator_A07() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    @Override
    public Subject authenticate(Subject subject, Credential credential) {
        String userName = null;
        String password = null;

        try {
            userName = credential.getCaller();
            password = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));
        } catch (Exception e) {
            throw new UsernamePasswordAuthenticationException("Invalid Credentials");
        }

        if (users.containsKey(userName) && users.get(userName).equals(password)) {
            return subject;
        } else {
            throw new UsernamePasswordAuthenticationException("Invalid Credentials");
        }
    }
}