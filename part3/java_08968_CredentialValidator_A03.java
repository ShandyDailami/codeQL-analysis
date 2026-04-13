import java.util.HashMap;
import java.util.Map;

public class java_08968_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_08968_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    @Override
    public boolean validate(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}