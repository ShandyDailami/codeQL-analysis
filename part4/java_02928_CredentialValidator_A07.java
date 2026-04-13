import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_02928_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_02928_CredentialValidator_A07() {
        // Simulating a database of hardcoded credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        // Checking if the given credentials match the ones in the database
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("User successfully authenticated!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validator
        validator.validate("user1", "password1");
        validator.validate("user2", "wrong_password");
        validator.validate("unknown_user", "unknown_password");
    }
}