import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_25588_CredentialValidator_A08 {

    private Map<String, String> userCredentials;

    public java_25588_CredentialValidator_A08() {
        this.userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user1";
        String password = "password1";

        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}