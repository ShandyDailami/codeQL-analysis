import java.util.Arrays;
import java.util.List;

public class java_22637_CredentialValidator_A03 {
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public static boolean validatePassword(String password) {
        return ALLOWED_PASSWORDS.contains(password);
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("password1")); // true
        System.out.println(validatePassword("invalidPassword")); // false
    }
}