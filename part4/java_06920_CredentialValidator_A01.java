import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_06920_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_06920_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if (validator.validate("user2", "password2")) {
            System.out.println("Access granted for user2");
        } else {
            System.out.println("Access denied for user2");
        }
    }
}