import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_09169_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_09169_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            System.out.println("Credentials validated successfully for user: " + user);
            return true;
        } else {
            System.out.println("Invalid credentials for user: " + user);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        validator.validate("user1", "password1"); // Should print: "Credentials validated successfully for user: user1"
        validator.validate("user2", "password2"); // Should print: "Credentials validated successfully for user: user2"
        validator.validate("user1", "wrongPassword"); // Should print: "Invalid credentials for user: user1"
        validator.validate("unknownUser", "somePassword"); // Should print: "Invalid credentials for user: unknownUser"
    }
}