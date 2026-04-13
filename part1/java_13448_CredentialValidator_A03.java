import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13448_CredentialValidator_A03 {

    // HashMap to hold credential pairs
    private Map<String, String> credentials;

    // Constructor
    public java_13448_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    // Method to add new credentials
    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encodedPassword);
    }

    // Method to validate credentials
    public boolean validateCredential(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String expectedPassword = this.credentials.get(username);
        String inputPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (!inputPassword.equals(expectedPassword)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Access granted");
        return true;
    }
}