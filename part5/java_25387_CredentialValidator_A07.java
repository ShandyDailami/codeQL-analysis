import java.util.HashMap;
import java.util.Map;

public class java_25387_CredentialValidator_A07 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        String expectedPassword = credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // true
        System.out.println(validate("user1", "wrongPassword")); // false
        System.out.println(validate("user4", "password4")); // false
    }
}