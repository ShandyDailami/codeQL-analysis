import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_09174_CredentialValidator_A07 {

    private Map<String, String> userCredentials;

    public java_09174_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        if (userCredentials.containsKey(username)
                && userCredentials.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}