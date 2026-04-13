import java.util.HashMap;
import java.util.Map;

public class java_34904_CredentialValidator_A03 {
    private Map<String, String> userMap;

    public java_34904_CredentialValidator_A03() {
        this.userMap = new HashMap<>();
        this.userMap.put("admin", "password"); // This should be kept in a secure environment
    }

    public boolean authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            System.out.println("Authenticated successfully!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.authenticate("admin", "password"); // Should print "Authenticated successfully!"
        validator.authenticate("admin", "wrongPassword"); // Should print "Authentication failed!"
    }
}