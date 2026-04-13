import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_11600_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_11600_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean authenticate(String user, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(user) && credentials.get(user).equals(encryptedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isAuthenticated = validator.authenticate("user1", "password1");
        System.out.println("User 1 is authenticated: " + isAuthenticated);

        isAuthenticated = validator.authenticate("user2", "wrongPassword");
        System.out.println("User 2 is authenticated: " + isAuthenticated);
    }
}