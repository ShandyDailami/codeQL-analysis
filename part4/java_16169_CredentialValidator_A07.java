import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_16169_CredentialValidator_A07 {

    private Map<String, String> userCredentials;

    public java_16169_CredentialValidator_A07() {
        // Hard-coded list of usernames and passwords
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        validator.validate("user1", "password1");
        validator.validate("user2", "wrongpassword");

        // Test invalid credentials
        validator.validate("wronguser", "wrongpassword");
    }
}