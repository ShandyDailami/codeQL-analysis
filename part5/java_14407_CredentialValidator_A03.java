import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14407_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_14407_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String encodedPassword = this.credentials.get(username);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);
            return decodedPassword.equals(password);
        } else {
            System.out.println("Invalid username");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validateCredentials("user1", "password1");
        System.out.println("Valid: " + valid);
    }
}