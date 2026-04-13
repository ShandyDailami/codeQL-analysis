import java.util.HashMap;
import java.util.Map;

public class java_04810_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_04810_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // In a real-world application, this would be a more complex validation process
        // Here we're just checking if the username and password match our known ones
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidatorEnterprise validator = new CredentialValidatorEnterprise();
        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // false
    }
}