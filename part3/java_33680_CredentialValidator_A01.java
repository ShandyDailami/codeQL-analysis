import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33680_CredentialValidator_A01 {
    private static final String SALT = "SALT";

    public static String hash(String password, String salt) {
        return Base64.getEncoder().encodeToString((salt + password + salt).getBytes());
    }

    public static boolean validate(String password, String hash, String salt) {
        return hash.equals(hash(password, salt));
    }

    public static String generateSalt() {
        return Base64.getEncoder().encodeToString(java.util.UUID.randomUUID().toString().getBytes());
    }

    public static Map<String, String> validateCredentials(String user, String password) {
        Map<String, String> result = new HashMap<>();
        String salt = generateSalt();
        String hashedPassword = hash(password, salt);

        // Assume we have a database of users
        Map<String, String> users = new HashMap<>();
        users.put("user1", "hashedPassword1");
        users.put("user2", "hashedPassword2");

        if (users.containsKey(user) && validate(password, users.get(user), salt)) {
            result.put("status", "Success");
            result.put("message", "Logged in successfully");
        } else {
            result.put("status", "Failure");
            result.put("message", "Invalid credentials");
        }

        return result;
    }
}