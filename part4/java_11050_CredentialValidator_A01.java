import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_11050_CredentialValidator_A01 {

    // In a real-world scenario, these would be stored in a database or in an external file
    private static Map<String, String> validUsers = new HashMap<>();

    static {
        validUsers.put("admin", "YWRtaSBlZCBib2R5");  // This is Base64 encoded 'admin:admin'
        validUsers.put("user1", "ZW5jb2RlZCB0ZXh0");  // This is Base64 encoded 'user1:user1'
    }

    public boolean validate(String username, String password) {
        String expectedPassword = validUsers.get(username);

        // If the username or password is not found in the map, return false
        if (expectedPassword == null) {
            System.out.println("Invalid username or password");
            return false;
        }

        // Decode the expected password from Base64
        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);

        // Compare the decoded passwords
        String decodedPasswordStr = new String(decodedPassword);
        if (decodedPasswordStr.equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validator
        validator.validate("admin", "password");  // Should return true
        validator.validate("admin", "wrongpassword");  // Should return false
        validator.validate("unknownuser", "password");  // Should return false
    }
}