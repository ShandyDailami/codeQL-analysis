import java.util.HashMap;
import java.util.Map;

public class java_41928_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_41928_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}