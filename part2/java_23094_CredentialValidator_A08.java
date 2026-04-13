import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23094_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_23094_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        // Add some example credentials for testing
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (!this.credentials.containsKey(user)) {
            System.out.println("Invalid user: " + user);
            return false;
        }

        String expectedPassword = this.credentials.get(user);

        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        String actualPassword = new String(decodedPassword);

        if (actualPassword.equals(password)) {
            System.out.println("Credentials validated for user: " + user);
            return true;
        } else {
            System.out.println("Invalid password for user: " + user);
            return false;
        }
    }
}