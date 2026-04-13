import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_40559_CredentialValidator_A03 {

    // Store username and password in a map
    private static Map<String, String> credentials = new HashMap<>();

    // Static block to initialize credentials
    static {
        credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    // Method to validate the credentials
    public static boolean validate(String username, String password) {
        String expectedPassword = credentials.get(username);
        if (expectedPassword != null) {
            return expectedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the validate method
        boolean validated = CredentialValidator.validate("admin", "password");
        System.out.println("Validated: " + validated);
    }
}