import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_15523_CredentialValidator_A07 implements CredentialValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean isValid(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}

interface CredentialValidator {
    boolean isValid(String password);
}