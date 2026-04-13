import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_34022_CredentialValidator_A07 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}