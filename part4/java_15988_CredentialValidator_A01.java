import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_15988_CredentialValidator_A01 {
    private Map<String, String> users;

    public java_15988_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (users.containsKey(username)) {
            String encodedPassword = users.get(username);
            String[] decodedPassword = new String(Base64.getDecoder().decode(encodedPassword));
            return decodedPassword[1].equals(password);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate("admin", "admin")); // true
        System.out.println(validator.validate("user", "user")); // true
        System.out.println(validator.validate("admin", "wrongpassword")); // false
        System.out.println(validator.validate("unknown", "unknown")); // false
    }
}