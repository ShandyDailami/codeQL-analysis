import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_34911_CredentialValidator_A07 {
    private static final Pattern PASSWORD_PATTERN;

    static {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        PASSWORD_PATTERN = Pattern.compile(pattern);
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isValidPassword("YourPassword123")); // true
        System.out.println(validator.isValidPassword("yourpassword")); // false
    }
}