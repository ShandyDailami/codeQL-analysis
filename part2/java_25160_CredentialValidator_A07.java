import java.util.HashMap;
import java.util.Map;

public class java_25160_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_25160_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    @Override
    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // This is a dummy method, it is required by the CredentialValidator interface
    @Override
    public void setConfig(Map<String, String> config) {
        // This method is not used in this example, but is required by the CredentialValidator interface
    }

    // This is a dummy method, it is required by the CredentialValidator interface
    @Override
    public Map<String, String> getConfig() {
        // This method is not used in this example, but is required by the CredentialValidator interface
        return null;
    }
}