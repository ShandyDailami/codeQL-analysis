import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34473_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_34473_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String user = "user1";
        String password = "password1";
        if (validator.validateCredentials(user, password)) {
            System.out.println("Access granted for user: " + user);
        } else {
            System.out.println("Access denied for user: " + user);
        }

        user = "wrongUser";
        password = "wrongPassword";
        if (validator.validateCredentials(user, password)) {
            System.out.println("Access granted for user: " + user);
        } else {
            System.out.println("Access denied for user: " + user);
        }
    }
}