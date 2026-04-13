import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_40055_CredentialValidator_A01 {
    private Map<String, String> credentials = new HashMap<>();

    public java_40055_CredentialValidator_A01() {
        // Add some default credentials for testing
        credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        credentials.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("user2:user2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(username) && credentials.get(username).equals(encodedPassword);
    }
}