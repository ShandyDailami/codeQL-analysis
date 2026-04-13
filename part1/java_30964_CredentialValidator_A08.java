import java.util.HashSet;
import java.util.Set;

public class java_30964_CredentialValidator_A08 {
    private static final Set<String> ALLOWED_USERS = new HashSet<>();
    private static final Set<String> ALLOWED_PASSWORDS = new HashSet<>();

    static {
        ALLOWED_USERS.add("user1");
        ALLOWED_USERS.add("user2");
        ALLOWED_USERS.add("user3");

        ALLOWED_PASSWORDS.add("password1");
        ALLOWED_PASSWORDS.add("password2");
        ALLOWED_PASSWORDS.add("password3");
    }

    public static boolean validate(String user, String password) {
        return ALLOWED_USERS.contains(user) && ALLOWED_PASSWORDS.contains(password);
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // true
        System.out.println(validate("user4", "password4")); // false
    }
}