import java.util.HashMap;
import java.util.Map;

public class java_41395_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_41395_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        return this.credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("admin", "password")) {
            System.out.println("Access granted for admin");
        } else {
            System.out.println("Access denied");
        }

        if (validator.validate("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied");
        }

        if (validator.validate("user2", "password2")) {
            System.out.println("Access granted for user2");
        } else {
            System.out.println("Access denied");
        }
    }
}