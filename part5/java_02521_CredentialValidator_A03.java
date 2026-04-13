import java.util.Objects;
import java.util.regex.Pattern;

public class java_02521_CredentialValidator_A03 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isPasswordValid(String password) {
        if (Objects.isNull(password) || password.isEmpty()) {
            throw new IllegalArgumentException("Password can't be null or empty");
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}