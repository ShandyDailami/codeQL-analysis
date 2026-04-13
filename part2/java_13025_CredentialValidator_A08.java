import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13025_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_13025_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        // Add some hardcoded credentials
        this.credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        this.credentials.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(username) && credentials.get(username).equals(encodedPassword);
    }
}