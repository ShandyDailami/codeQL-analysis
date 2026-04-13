import java.util.HashMap;
import java.util.Map;

public class java_27695_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_27695_CredentialValidator_A03() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        return password.equals(credentials.get(username));
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate with correct credentials
        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is valid: " + isValid);

        // Validate with incorrect credentials
        isValid = validator.validate("user3", "wrongpassword");
        System.out.println("Is valid: " + isValid);
    }
}