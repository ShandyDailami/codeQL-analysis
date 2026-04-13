import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_25668_CredentialValidator_A08 {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("userpassword".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // If the user does not exist, return false.
        if (!users.containsKey(username)) {
            return false;
        }

        // If the passwords do not match, return false.
        if (!users.get(username).equals(encodedPassword)) {
            return false;
        }

        // If everything is ok, return true.
        return true;
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        System.out.println(validator.validate("admin", "password"));  // Returns true
        System.out.println(validator.validate("user", "userpassword"));  // Returns false
        System.out.println(validator.validate("admin", "wrongpassword"));  // Returns false
        System.out.println(validator.validate("nonExistentUser", "nonExistentPassword"));  // Returns false
    }
}