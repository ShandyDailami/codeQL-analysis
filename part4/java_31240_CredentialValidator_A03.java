import java.util.HashMap;
import java.util.Map;

public class java_31240_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_31240_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        String expectedPassword = this.credentials.get(user);
        if (expectedPassword == null) {
            System.out.println("User not found");
            return false;
        }

        if (expectedPassword.equals(password)) {
            System.out.println("Credentials validated successfully");
            return true;
        } else {
            System.out.println("Credentials do not match");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1"); // This should return true
        validator.validateCredentials("user4", "password4"); // This should return false
    }
}