import java.util.HashMap;
import java.util.Map;

public class java_36335_CredentialValidator_A01 {

    // In a real application, this would be fetched from a database
    private Map<String, String> userCredentials;

    public java_36335_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean checkCredentials(String username, String password) {
        if(userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Example usage
        boolean isValid = validator.checkCredentials("user1", "password1");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? true

        isValid = validator.checkCredentials("user1", "wrong_password");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? false
    }
}