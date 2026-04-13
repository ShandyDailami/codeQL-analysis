import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28220_CredentialValidator_A01 {

    private Map<String, String> userCredentials;

    public java_28220_CredentialValidator_A01() {
        this.userCredentials = new HashMap<>();
        initUserCredentials();
    }

    private void initUserCredentials() {
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        userCredentials.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (userCredentials.containsKey(user)) {
            String storedPassword = userCredentials.get(user);
            return storedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid);
    }
}