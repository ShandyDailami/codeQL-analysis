import java.util.Base64;
import java.util.HashMap;

public class java_19360_CredentialValidator_A07 {
    private HashMap<String, String> userCredentials;

    public java_19360_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean isValid(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.isValid("user1", "password1");
        System.out.println("Is valid: " + isValid); // should print true

        isValid = validator.isValid("user3", "password3");
        System.out.println("Is valid: " + isValid); // should print false
    }
}