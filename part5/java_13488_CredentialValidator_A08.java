import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13488_CredentialValidator_A08 {

    // This is a simple in-memory store of user credentials for this example
    private Map<String, String> userCredentials = new HashMap<>();

    public java_13488_CredentialValidator_A08() {
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validateCredentials("user1", "password1");
        System.out.println("Valid credentials: " + valid);
    }
}