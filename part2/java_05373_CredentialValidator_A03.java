import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05373_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_05373_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, this.encodePassword(password));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = this.encodePassword(password);
        return this.credentials.get(username).equals(encodedPassword);
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user2", "password2")); // true
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // false
    }
}