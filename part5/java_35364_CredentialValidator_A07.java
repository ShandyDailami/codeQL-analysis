import java.util.HashMap;
import java.util.Map;

public class java_35364_CredentialValidator_A07 {
    private Map<String, String> userData;

    public java_35364_CredentialValidator_A07() {
        userData = new HashMap<>();
        // Add some user data to the map
        userData.put("user1", "password1");
        userData.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (userData.containsKey(username) && userData.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid);

        isValid = validator.validateCredentials("user3", "password3");
        System.out.println("Is valid: " + isValid);
    }
}