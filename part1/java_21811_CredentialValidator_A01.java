import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_21811_CredentialValidator_A01 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean isValidPassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "ThisIsMyPassword";
        System.out.println(validator.isValidPassword(password));
    }
}