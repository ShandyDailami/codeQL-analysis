import java.util.HashMap;
import java.util.Map;

public class java_15996_CredentialValidator_A08 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_15996_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    @Override
    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}