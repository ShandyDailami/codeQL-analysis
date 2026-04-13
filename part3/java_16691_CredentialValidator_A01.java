import java.util.HashMap;
import java.util.Map;

public class java_16691_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_16691_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        String expectedPassword = this.credentials.get(username);

        if (expectedPassword == null) {
            return false;
        }

        return expectedPassword.equals(password);
    }
}