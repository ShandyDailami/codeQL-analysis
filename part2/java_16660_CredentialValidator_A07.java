import java.util.HashMap;
import java.util.Map;

public class java_16660_CredentialValidator_A07 {

    private static Map<String, String> validUsers = new HashMap<>();

    static {
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        return password.equals(validUsers.get(user));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password1"));  // should print true
        System.out.println(validator.validate("user4", "password4"));  // should print false
    }
}