import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_07833_CredentialValidator_A07 {

    // Store users in a map for simplicity. In a real scenario,
    // this would likely be fetched from a database or some other source.
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("alice", Base64.getEncoder().encodeToString("alice:alice".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("bob:bob".getBytes()));
    }

    public boolean validate(String username, String password) {
        String expectedPassword = users.get(username);

        // If expected password is not found, return false.
        if (expectedPassword == null) {
            return false;
        }

        // Decode the password from base64 and compare it with the expected password.
        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        String decodedPasswordStr = new String(decodedPassword);

        return decodedPasswordStr.equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("alice", "alice")); // prints true
        System.out.println(validator.validate("bob", "bob")); // prints true
        System.out.println(validator.validate("alice", "wrongpassword")); // prints false
    }
}