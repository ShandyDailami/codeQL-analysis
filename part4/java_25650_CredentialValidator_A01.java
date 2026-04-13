import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_25650_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_25650_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if(credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        validator.validate("user1", "password1"); // true
        validator.validate("user1", "wrongpassword"); // false
        validator.validate("user4", "password4"); // false
    }
}