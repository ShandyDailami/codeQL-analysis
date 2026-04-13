import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03640_CredentialValidator_A01 {

    private Map<String, String> credentialStore;

    public java_03640_CredentialValidator_A01() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentialStore.put(username, encodedPassword);
    }

    public boolean validateCredential(String username, String password) {
        if (!this.credentialStore.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String encodedPassword = this.credentialStore.get(username);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);

        if (!decodedPassword.equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        return true;
    }
}