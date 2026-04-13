import java.util.HashMap;
import java.util.Map;

public class java_05039_CredentialValidator_A03 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        return credentials.get(username) != null && credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("user1", "password1")) {
            System.out.println("Validated successfully with user1's credentials");
        } else {
            System.out.println("Failed to validate with user1's credentials");
        }

        if (validator.validate("user2", "wrongPassword")) {
            System.out.println("Validated successfully with user2's credentials");
        } else {
            System.out.println("Failed to validate with user2's credentials");
        }

        if (validator.validate("user3", "password3")) {
            System.out.println("Validated successfully with user3's credentials");
        } else {
            System.out.println("Failed to validate with user3's credentials");
        }
    }
}