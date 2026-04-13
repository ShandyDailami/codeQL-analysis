import java.util.HashMap;
import java.util.Map;

public class java_28811_CredentialValidator_A07 {
    private static Map<String, String> validUsers = new HashMap<>();

    static {
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public static boolean validate(String user, String password) {
        if (validUsers.containsKey(user) && validUsers.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // should print true
        System.out.println(validate("user4", "password4")); // should print false
    }
}