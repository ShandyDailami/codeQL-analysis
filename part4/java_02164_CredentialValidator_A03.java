import java.util.HashMap;
import java.util.Map;

public class java_02164_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_02164_CredentialValidator_A03() {
        // Create a sample set of credentials
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    @Override
    public boolean validate(String username, String password) {
        // Check if the entered credentials match those in our set
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}