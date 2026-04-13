import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16391_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_16391_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredential(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        if (!this.credentials.get(username).equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Credentials validated successfully!");
        return true;
    }
}