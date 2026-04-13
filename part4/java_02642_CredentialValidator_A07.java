import java.util.HashMap;
import java.util.Map;

public class java_02642_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_02642_CredentialValidator_A07() {
        // Initialize the credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        // Check if the given credentials are valid
        return this.credentials.get(user).equals(password);
    }

}