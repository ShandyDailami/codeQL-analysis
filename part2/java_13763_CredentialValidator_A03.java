import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13763_CredentialValidator_A03 {
    public static Map<String, String> credentials = new HashMap<>();

    public java_13763_CredentialValidator_A03() {
        credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (!credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String expectedPassword = credentials.get(username);

        if (!expectedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Successfully logged in!");
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password"); // This should print "Successfully logged in!"
        validator.validate("admin", "wrongpassword"); // This should print "Invalid password" and "Invalid username"
    }
}