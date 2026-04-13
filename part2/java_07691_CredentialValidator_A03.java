import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_07691_CredentialValidator_A03 {

    public Map<String, String> validate(String username, String password) throws LoginException {
        Map<String, String> loginDetails = new HashMap<>();
        if ("admin".equals(username) && "password".equals(password)) {
            String credentials = username + ":" + password;
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
            loginDetails.put("Authentication", encodedCredentials);
        } else {
            throw new LoginException("Invalid username or password");
        }
        return loginDetails;
    }

    public Credential validation(Credential credential) throws LoginException {
        String user = credential.getCaller();
        String password = new String(Base64.getDecoder().decode(credential.getIdentifier()));
        if ("admin".equals(user) && "password".equals(password)) {
            return new UsernamePasswordCredential(user, password);
        } else {
            throw new LoginException("Invalid username or password");
        }
    }
}