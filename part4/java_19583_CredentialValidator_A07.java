import java.util.HashMap;
import java.util.Map;

public class java_19583_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_19583_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("admin", "password")) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Failed to validate!");
        }

        if (validator.validate("user1", "password1")) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Failed to validate!");
        }

        if (validator.validate("user2", "password2")) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Failed to validate!");
        }
    }
}