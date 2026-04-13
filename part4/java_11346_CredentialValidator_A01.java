import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_11346_CredentialValidator_A01 {

    private Map<String, String> credentials = new HashMap<>();

    public java_11346_CredentialValidator_A01() {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Both username and password must be provided.");
        }

        if (!credentials.containsKey(username)) {
            throw new InvalidParameterException("Invalid username.");
        }

        if (!credentials.get(username).equals(password)) {
            throw new InvalidParameterException("Invalid password.");
        }

        return true;
    }
}