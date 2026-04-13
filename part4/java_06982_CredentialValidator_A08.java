import java.util.HashMap;
import java.util.Map;

public class java_06982_CredentialValidator_A08 {

    // Predefined set of credentials
    private static Map<String, String> predefinedCredentials = new HashMap<>();

    static {
        predefinedCredentials.put("user1", "password1");
        predefinedCredentials.put("user2", "password2");
        predefinedCredentials.put("user3", "password3");
    }

    // CredentialValidator interface
    public interface CredentialValidator {
        boolean validate(String username, String password);
    }

    // CustomCredentialValidator class
    public static class CustomCredentialValidatorImpl implements CredentialValidator {

        @Override
        public boolean validate(String username, String password) {
            // Check if the username and password match the predefined set
            return predefinedCredentials.get(username).equals(password);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CustomCredentialValidatorImpl();

        String username = "user1";
        String password = "password1";

        if (validator.validate(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }

        username = "user2";
        password = "wrongPassword";

        if (validator.validate(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}