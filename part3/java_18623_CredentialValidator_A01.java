import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_18623_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_18623_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        initCredentials();
    }

    private void initCredentials() {
        // Add some initial credentials
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.get(username) != null && credentials.get(username).equals(encodedPassword);
    }
}