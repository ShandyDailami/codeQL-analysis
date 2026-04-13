import java.util.HashSet;
import java.util.Set;

public class java_20074_CredentialValidator_A07 {
    private static final Set<String> COMMON_PASSWORDS = new HashSet<>();

    static {
        COMMON_PASSWORDS.add("password");
        COMMON_PASSWORDS.add("password1");
        COMMON_PASSWORDS.add("password2");
        // add more common passwords as needed
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (COMMON_PASSWORDS.contains(password)) {
            return false;
        }

        return true;
    }
}