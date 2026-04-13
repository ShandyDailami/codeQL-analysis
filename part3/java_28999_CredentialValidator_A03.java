import java.util.HashMap;
import java.util.Map;

public class java_28999_CredentialValidator_A03 {

    // In-memory database of users
    private Map<String, String> userDatabase;

    // Constructor
    public java_28999_CredentialValidator_A03() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    // Method to validate the user's credentials
    public boolean validateCredentials(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid? " + isValid);
    }
}