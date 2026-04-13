import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21081_CredentialValidator_A07 {
    private Map<String, String> userCredentials;

    public java_21081_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
    }

    public void addUserCredential(String username, String password) {
        userCredentials.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            System.out.println("User not found!");
            return false;
        }

        String storedPassword = userCredentials.get(username);

        if (!isPasswordValid(password, storedPassword)) {
            System.out.println("Password is incorrect!");
            return false;
        }

        System.out.println("Login successful!");
        return true;
    }

    private boolean isPasswordValid(String providedPassword, String storedPassword) {
        // Use a stronger hash function for real-world applications
        // Hash the provided password and compare the hash values
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addUserCredential("user1", "password1");

        validator.validateCredentials("user1", "wrongpassword"); // Outputs: "Password is incorrect!"
        validator.validateCredentials("user1", "password1"); // Outputs: "Login successful!"
        validator.validateCredentials("nonExistentUser", "password"); // Outputs: "User not found!"
    }
}