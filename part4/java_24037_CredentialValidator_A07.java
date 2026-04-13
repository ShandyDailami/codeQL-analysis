import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_24037_CredentialValidator_A07 {
    // Simulate a database with username and password.
    private Map<String, String> database;

    public java_24037_CredentialValidator_A07() {
        database = new HashMap<>();
        database.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        database.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = database.get(username);

        if (encodedPassword != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);

            return decodedPassword.equals(password);
        }

        return false;
    }

    public static void main(String[] args) {
        AuthFailureCredentialValidator validator = new AuthFailureCredentialValidator();

        boolean valid = validator.validate("user1", "password1");
        System.out.println("Valid: " + valid);

        valid = validator.validate("user2", "wrongpassword");
        System.out.println("Valid: " + valid);
    }
}