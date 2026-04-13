import java.util.HashMap;
import java.util.Map;

public class java_41978_CredentialValidator_A08 {

    // Predefined credentials
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        // Add predefined credentials to the HashMap
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the provided username and password match the predefined credentials
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Login Failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        validator.validate("user1", "password1"); // Should print "Login Successful!"
        validator.validate("user4", "password4"); // Should print "Login Failed!"
        validator.validate("user1", "wrong_password"); // Should print "Login Failed!"
    }
}