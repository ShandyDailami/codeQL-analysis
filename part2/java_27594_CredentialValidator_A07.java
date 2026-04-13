import java.util.HashMap;
import java.util.Map;

public class java_27594_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_27594_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "pass1");
        this.credentials.put("user2", "pass2");
    }

    public boolean validate(String username, String password) {
        return this.credentials.containsKey(username)
                && this.credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validate("user1", "pass1");
        System.out.println("Validation result: " + valid);
    }
}