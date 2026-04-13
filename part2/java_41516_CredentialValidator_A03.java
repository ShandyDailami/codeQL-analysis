import java.util.HashMap;
import java.util.Map;

public class java_41516_CredentialValidator_A03 {
    private Map<String, String> users;

    public java_41516_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("admin", "password");
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("admin", "password")); // true
        System.out.println(validator.validateCredentials("admin", "wrongpassword")); // false
        System.out.println(validator.validateCredentials("unknownuser", "unknownpassword")); // false
    }
}