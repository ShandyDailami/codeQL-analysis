import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21476_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_21476_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String storedPassword = this.credentials.get(username);
            return storedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        String validUsername = "user1";
        String validPassword = "password1";
        System.out.println(validator.validate(validUsername, validPassword));  // Should print true

        String invalidUsername = "user3";
        String invalidPassword = "invalid";
        System.out.println(validator.validate(invalidUsername, invalidPassword));  // Should print false
    }
}