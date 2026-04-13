import java.util.HashMap;
import java.util.Map;

public class java_10348_CredentialValidator_A07 {
    private Map<String, String> userCredentials;

    public java_10348_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String storedPassword = userCredentials.get(username);
        if (storedPassword == null) {
            System.out.println("Invalid username.");
            return false;
        }

        if (storedPassword.equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid password.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user2", "wrongpassword");
        validator.validateCredentials("unknownuser", "password");
    }
}