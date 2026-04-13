import java.util.HashMap;
import java.util.Map;

public class java_31148_CredentialValidator_A01 {
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("user1", "password1")); // prints: true
        System.out.println(validator.validate("user2", "wrongPassword")); // prints: false
   .
    }
}