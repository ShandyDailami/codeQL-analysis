import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_35911_CredentialValidator_A03 {

    private static final Set<String> WEAK_PASSWORDS = new HashSet<>(Arrays.asList(
        "123456", "password", "admin", "qwerty", "admin1", "password1", "1234567", "111111", "123321"
    ));

    public static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (WEAK_PASSWORDS.contains(password)) {
            return false;
        }

        return true;
    }

}