import java.util.HashMap;
import java.util.Map;

public class java_30492_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_30492_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1"); // should print: Access granted for user: user1
        validator.validateCredentials("user3", "password3"); // should print: Access denied for user: user3
    }
}