import java.util.HashMap;
import java.util.Map;

public class java_15725_CredentialValidator_A03 {

    private static Map<String, String> validUsers = new HashMap<>();

    static {
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public static boolean validate(String user, String password) {
        if (user == null || password == null) {
            return false;
        }

        String expectedPassword = validUsers.get(user);
        return expectedPassword != null && expectedPassword.equals(password);
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // Should print true
        System.out.println(validate("user1", "wrongpassword")); // Should print false
        System.out.println(validate("user4", "password4")); // Should print false
    }
}