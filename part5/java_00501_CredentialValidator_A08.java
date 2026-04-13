import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_00501_CredentialValidator_A08 {

    private Map<String, String> users = new HashMap<>();

    public java_00501_CredentialValidator_A08() {
        users.put("user1", "password1"); // should be hashed
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        String expectedPassword = users.get(user);

        if (expectedPassword == null) {
            throw new RuntimeException("User not found in the system: " + user);
        }

        // In a real-world application, you should never compare plain text passwords
        // Use a hashing algorithm like SHA-256
        byte[] expectedPasswordBytes = expectedPassword.getBytes();
        byte[] enteredPasswordBytes = password.getBytes();

        boolean passwordsMatch = true;
        for (int i = 0; i < expectedPasswordBytes.length && i < enteredPasswordBytes.length; i++) {
            passwordsMatch &= expectedPasswordBytes[i] == enteredPasswordBytes[i];
        }

        if (!passwordsMatch) {
            throw new RuntimeException("Invalid password for user: " + user);
        }

        return passwordsMatch;
    }
}