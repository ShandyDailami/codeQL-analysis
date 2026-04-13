import java.util.HashSet;
import java.util.Set;

public class java_10166_CredentialValidator_A07 {

    private static final Set<String> commonPasswords = new HashSet<String>() {{
        add("password");
        add("123456");
        add("123456789");
        // add more common passwords here...
    }};

    public boolean isPasswordStrongEnough(String password) {
        return password != null && password.length() >= 8 &&
                containsUpperCase(password) && containsLowerCase(password) &&
                containsDigit(password) && !commonPasswords.contains(password);
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }
}