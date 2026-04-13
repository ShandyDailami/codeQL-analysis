import java.util.Base64;
import java.util.HashMap;

public class java_17647_CredentialValidator_A01 {

    // Using a HashMap for storing username and password for simplicity
    private HashMap<String, String> credentials;

    public java_17647_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Adding some dummy credentials
        this.credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // This method will validate the provided username and password.
    public boolean validateCredentials(String username, String password) {
        // Decoding the password and checking if it matches the stored password
        return Base64.getEncoder().encodeToString(password.getBytes()).equals(this.credentials.get(username));
    }
}