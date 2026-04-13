import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_25499_CredentialValidator_A08 {

    // For simplicity, let's assume the users' passwords are stored in memory. In a real-world application,
    // you would likely fetch these from a database or another persistent storage.
    private Map<String, String> userPasswords = new HashMap<>();

    public java_25499_CredentialValidator_A08() {
        // Add some users for demonstration.
        userPasswords.put("alice", "alice");
        userPasswords.put("bob", "bob");
    }

    public boolean validate(String userName, String password) {
        // We're using Base64 to encode the passwords, so they can't be directly compared.
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Compare the passwords. If they match, return true, otherwise false.
        return userPasswords.get(userName).equals(encodedPassword);
    }
}