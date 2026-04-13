import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36339_CredentialValidator_A03 {
    private Map<String, String> credentialStore;

    public java_36339_CredentialValidator_A03() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        this.credentialStore.put(username, encryptedPassword);
    }

    public boolean validateCredential(String username, String password) {
        String encryptedPassword = this.credentialStore.get(username);
        return encryptedPassword != null && encryptedPassword.equals(encryptPassword(password));
    }

    private String encryptPassword(String password) {
        byte[] encryptedPassword = password.getBytes();
        return Base64.getEncoder().encodeToString(encryptedPassword);
    }

    private String decryptPassword(String encryptedPassword) {
        byte[] decodedPassword = Base64.getDecoder().decode(encryptedPassword);
        return new String(decodedPassword);
    }
}