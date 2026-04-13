import java.util.HashMap;
import java.util.Map;

public class java_14535_CredentialValidator_A01 {
    private Map<String, String> userPasswords;

    public java_14535_CredentialValidator_A01() {
        userPasswords = new HashMap<>();
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (userPasswords.containsKey(username) && userPasswords.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        validator.validate("user1", "password1"); // should print "Access granted for user: user1"
        validator.validate("user3", "password1"); // should print "Access denied for user: user3"
    }
}