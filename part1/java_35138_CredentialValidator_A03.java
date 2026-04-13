import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_35138_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_35138_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean isValid(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.isValid("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if (validator.isValid("user2", "password2")) {
            System.out.println("Access granted for user2");
        } else {
            System.out.println("Access denied for user2");
        }
    }
}