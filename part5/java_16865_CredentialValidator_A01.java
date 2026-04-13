import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16865_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_16865_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("alice", Base64.getEncoder().encodeToString("alice:password".getBytes()));
        this.credentials.put("bob", Base64.getEncoder().encodeToString("bob:password".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            return false;
        }

        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        String actualPassword = new String(decodedPassword);
        return actualPassword.equals(password);
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate Alice's credentials
        String aliceUsername = "alice";
        String alicePassword = "password";
        boolean isAliceValid = validator.validateCredentials(aliceUsername, alicePassword);
        if (isAliceValid) {
            System.out.println("Alice is valid.");
        } else {
            System.out.println("Alice is not valid.");
        }

        // Validate Bob's credentials
        String bobUsername = "bob";
        String bobPassword = "password";
        boolean isBobValid = validator.validateCredentials(bobUsername, bobPassword);
        if (isBobValid) {
            System.out.println("Bob is valid.");
        } else {
            System.out.println("Bob is not valid.");
        }
    }
}