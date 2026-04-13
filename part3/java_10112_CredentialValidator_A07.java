import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;

public class java_10112_CredentialValidator_A07 {

    private Map<String, String> users = new HashMap<>();

    public java_10112_CredentialValidator_A07() {
        users.put("user1", "password1"); // This should be encrypted in a real-world application
        users.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = users.get(username);
        if (expectedPassword == null) {
            throw new IllegalStateException("Invalid username: " + username);
        }

        Decoder decoder = Base64.getDecoder();
        byte[] decodedExpectedPassword = decoder.decode(expectedPassword);
        byte[] decodedProvidedPassword = decoder.decode(password);

        for (int i = 0; i < decodedExpectedPassword.length; i++) {
            if (decodedExpectedPassword[i] != decodedProvidedPassword[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user1";
        String password = Base64.getEncoder().encodeToString("password1".getBytes());

        if (validator.validateCredentials(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}