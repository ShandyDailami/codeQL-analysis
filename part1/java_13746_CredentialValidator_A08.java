import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13746_CredentialValidator_A08 {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        // Add more users if necessary
    }

    public static boolean validate(String username, String password) {
        String expectedPassword = users.get(username);
        if (expectedPassword != null) {
            byte[] expectedPasswordBytes = Base64.getDecoder().decode(expectedPassword);
            byte[] providedPasswordBytes = Base64.getDecoder().decode(password);
            return MessageDigest.isEqual("password".getBytes(), providedPasswordBytes);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // Expected output: true
        System.out.println(validate("user1", "wrong_password")); // Expected output: false
    }
}