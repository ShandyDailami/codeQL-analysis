import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_19578_CredentialValidator_A01 {
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user1", "password1");
        validator.validate("user2", "password2");
        validator.validate("user3", "password3");
    }
}