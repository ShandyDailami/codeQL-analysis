import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_18738_CredentialValidator_A01 {
    private Map<String, String> credentials = new HashMap<>();

    public java_18738_CredentialValidator_A01() {
        // Add example credentials
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username)) {
            byte[] decodedBytes = Base64.getDecoder().decode(credentials.get(username));
            return password.equals(new String(decodedBytes));
        } else {
            throw new InvalidParameterException("Invalid username");
        }
    }
}