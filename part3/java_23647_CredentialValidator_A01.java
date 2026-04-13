import javax.naming.AuthenticationException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23647_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_23647_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public void validate(String user, String password) throws AuthenticationException, CredentialNotFoundException, LoginException {
        if (!credentials.containsKey(user)) {
            throw new CredentialNotFoundException("User not found");
        }

        byte[] decodedPassword = Base64.getDecoder().decode(credentials.get(user));
        String decodedPasswordString = new String(decodedPassword);

        if (!password.equals(decodedPasswordString)) {
            throw new AuthenticationException("Invalid password");
        }
    }
}