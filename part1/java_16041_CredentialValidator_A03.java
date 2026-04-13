import java.util.HashMap;
import java.util.Map;

public class java_16041_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_16041_CredentialValidator_A03() {
        // In a real-world application, you'd want to use a more secure
        // method of storing credentials, such as encrypted storage or a database.
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        // In a real-world application, you'd want to use a more secure
        // method of checking the password, such as a hash or salt.
        return password.equals(credentials.get(user));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validation process
        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is valid: " + isValid);

        isValid = validator.validate("user3", "password3");
        System.out.println("Is valid: " + isValid);
    }
}