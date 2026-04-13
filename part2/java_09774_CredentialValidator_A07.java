import java.util.HashMap;
import java.util.Map;

public class java_09774_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_09774_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        String expectedPassword = this.credentials.get(user);
        if (expectedPassword == null) {
            System.out.println("Invalid username");
            return false;
        }

        if (expectedPassword.equals(password)) {
            System.out.println("Successfully authenticated");
            return true;
        } else {
            System.out.println("Invalid password");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user2", "wrongpassword");
        validator.validateCredentials("user4", "password4");
    }
}