import java.util.HashMap;
import java.util.Map;

public class java_21867_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_21867_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        String expectedPassword = userCredentials.get(user);
        if (expectedPassword == null) {
            System.out.println("User not found in the system");
            return false;
        }

        if (expectedPassword.equals(password)) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Incorrect password");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user2", "wrongpassword");
    }
}