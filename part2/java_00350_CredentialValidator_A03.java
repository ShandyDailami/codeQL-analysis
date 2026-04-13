import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_00350_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_00350_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encodedPassword);
    }

    public boolean validateCredential(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String encodedPassword = this.credentials.get(username);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);

            return decodedPassword.equals(password);
        }

        return false;
    }
}