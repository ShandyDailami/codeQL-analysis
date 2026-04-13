import java.util.HashMap;
import java.util.Map;

public class java_14718_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_14718_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        return credentials.get(username).equals(password);
    }
}