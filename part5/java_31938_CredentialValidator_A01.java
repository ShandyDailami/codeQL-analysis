import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31938_CredentialValidator_A01 {
    private Map<String, String> credentials = new HashMap<>();

    public java_31938_CredentialValidator_A01() {
        // add some example credentials
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        // check if the user and password are in the map
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid); // should print true

        isValid = validator.validateCredentials("user3", "password3");
        System.out.println("Is valid: " + isValid); // should print false
    }
}