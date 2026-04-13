import java.util.HashMap;
import java.util.Map;

public class java_06543_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_06543_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addUser(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateUser(String username, String password) {
        if (this.credentials.containsKey(username)
                && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addUser("user1", "password1");
        validator.addUser("user2", "password2");

        System.out.println(validator.validateUser("user1", "password1")); // true
        System.out.println(validator.validateUser("user2", "password2")); // true
        System.out.println(validator.validateUser("user3", "password3")); // false
    }
}