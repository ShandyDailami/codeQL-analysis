import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32632_CredentialValidator_A01 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_32632_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encodedPassword);
    }

    @Override
    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(encodedPassword);
    }
}