import java.util.HashMap;
import java.util.Base64;

public class java_12196_SessionManager_A07 {
    private HashMap<String, String> credentials;

    public java_12196_SessionManager_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encryptedPassword);
    }

    public boolean authenticate(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(encryptedPassword);
    }
}