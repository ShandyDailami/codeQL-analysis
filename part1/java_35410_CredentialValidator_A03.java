import java.util.HashMap;
import java.util.Map;

public class java_35410_CredentialValidator_A03 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");

        System.out.println(validator.validateCredentials("user1", "password1", userCredentials)); // true
        System.out.println(validator.validateCredentials("user3", "password3", userCredentials)); // false
    }
}

class CredentialValidator {
    boolean validateCredentials(String username, String password, Map<String, String> userCredentials) {
        if (userCredentials.containsKey(username)) {
            return userCredentials.get(username).equals(password);
        }
        return false;
    }
}