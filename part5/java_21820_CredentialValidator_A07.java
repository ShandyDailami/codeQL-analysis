import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21820_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_21820_CredentialValidator_A07() {
        credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        credentials.put(username, encodedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(username) && encodedPassword.equals(credentials.get(username));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // false
        System.out.println(validator.validateCredentials("user2", "password2")); // true
        System.out.println(validator.validateCredentials("user2", "wrongpassword")); // false
    }
}