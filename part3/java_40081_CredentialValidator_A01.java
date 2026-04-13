import java.util.HashMap;
import java.util.Map;

public class java_40081_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_40081_CredentialValidator_A01() {
        // Initializing credentials in a secure manner is not required for this example
        // This is just a placeholder
        credentials = new HashMap<>();
        credentials.put("admin", "password");
    }

    @Override
    public boolean validate(String username, String password) {
        if (!credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        if (!credentials.get(username).equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Access granted for user: " + username);
        return true;
    }
}