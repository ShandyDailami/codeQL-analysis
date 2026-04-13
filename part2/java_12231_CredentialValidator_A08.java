import java.util.HashMap;
import java.util.Map;

public class java_12231_CredentialValidator_A08 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static class CredentialValidatorImpl implements CredentialValidator {

        @Override
        public boolean validate(String username, String password) {
            String correctPassword = credentials.get(username);
            return correctPassword != null && correctPassword.equals(password);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl();

        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user2", "wrongPassword")); // false
        System.out.println(validator.validate("user3", "password3")); // true
    }
}