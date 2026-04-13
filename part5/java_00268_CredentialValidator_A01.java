import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_00268_CredentialValidator_A01 {

    private Map<String, String> users = new HashMap<>();

    public java_00268_CredentialValidator_A01() {
        users.put("user1", "password1"); // This is a placeholder, replace with actual credentials.
        users.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        String expectedPassword = users.get(user);

        if (expectedPassword == null) {
            System.out.println("User not found.");
            return false;
        }

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (!encodedPassword.equals(expectedPassword)) {
            System.out.println("Password is incorrect.");
            return false;
        }

        System.out.println("Access granted.");
        return true;
    }
}