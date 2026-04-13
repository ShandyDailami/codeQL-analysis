import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34783_CredentialValidator_A07 {

    public static boolean validate(String user, String password) {
        // In a real application, you'd store the credentials in a secure way
        // This is just a placeholder for simplicity
        Map<String, String> credentials = new HashMap<>();
        credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));

        if (!credentials.containsKey(user) || !credentials.get(user).equals(password)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "password")); // prints: true
        System.out.println(validate("admin", "wrongpassword")); // prints: false
    }
}