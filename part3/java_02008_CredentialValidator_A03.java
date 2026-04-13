import java.util.HashMap;
import java.util.Map;

public class java_02008_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_02008_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        return password.equals(expectedPassword);
    }
}