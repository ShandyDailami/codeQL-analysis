import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_02879_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_02879_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, encodePassword(password));
    }

    public boolean validateCredential(String username, String password) {
        String hashedPassword = this.credentials.get(username);
        if (hashedPassword == null) {
            return false;
        }
        return isPasswordValid(hashedPassword, password);
    }

    private String encodePassword(String password) {
        byte[] hashedBytes = password.hashCode() + password.hashCode();
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    private boolean isPasswordValid(String hashedPassword, String password) {
        byte[] hashedPasswordBytes = Base64.getDecoder().decode(hashedPassword);
        byte[] passwordBytes = password.hashCode() + password.hashCode();
        return password.equals(new String(hashedPasswordBytes));
    }
}