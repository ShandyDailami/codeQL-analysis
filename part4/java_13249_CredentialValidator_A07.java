import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13249_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_13249_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encryptedPassword);
    }

    @Override
    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            if (this.credentials.get(username).equals(encryptedPassword)) {
                return true;
            }
        }
        return false;
    }
}