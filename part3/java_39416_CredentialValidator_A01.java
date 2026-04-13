import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39416_CredentialValidator_A01 {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "d031db69f8a3e8833c8f66c4fd26bfa9"); // Password is "admin"
    }

    public static void main(String[] args) {
        // Add your own authentication logic here
        String user = "admin";
        String password = "password";
        String hash = users.get(user);
        if (hash != null && hash.equals(hashPassword(password))) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}