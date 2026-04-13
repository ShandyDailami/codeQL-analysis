import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_24997_CredentialValidator_A03 implements CredentialValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public boolean isValid(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();

        String password = "thisIsAWeakPassword";
        boolean isValid = validator.isValid(password);

        System.out.println("Is the password strong enough? " + isValid);
    }
}