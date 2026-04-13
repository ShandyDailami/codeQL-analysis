import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_01066_CredentialValidator_A03 {

    // HashMap to store credentials
    private static Map<String, String> credentials;

    // Initialize the credentials
    static {
        credentials = new HashMap<>();
        credentials.put("admin", Base64.getEncoder().encodeToString("admin".getBytes()));
        credentials.put("user", Base64.getEncoder().encodeToString("user123".getBytes()));
    }

    // Method to validate the credentials
    public static boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "admin")); // True
        System.out.println(validate("user", "user123")); // True
        System.out.println(validate("admin", "wrongPassword")); // False
    }
}