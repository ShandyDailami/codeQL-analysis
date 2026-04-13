import java.util.HashMap;
import java.util.Map;

public class java_09732_CredentialValidator_A01 {
    private Map<String, String> userCredentials;

    public java_09732_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean isValidCredentials(String user, String password) {
        return userCredentials.containsKey(user) && userCredentials.get(user).equals(password);
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Validate user1's credentials
        if (validator.isValidCredentials("user1", "password1")) {
            System.out.println("Credentials are valid for user1");
        } else {
            System.out.println("Invalid credentials for user1");
        }

        // Validate user2's credentials
        if (validator.isValidCredentials("user2", "wrongpassword")) {
            System.out.println("Credentials are valid for user2");
        } else {
            System.out.println("Invalid credentials for user2");
        }
    }
}