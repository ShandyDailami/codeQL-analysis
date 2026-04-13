import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_15036_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_15036_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Fill the credentials map with some dummy data
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(encodedPassword);
    }
}