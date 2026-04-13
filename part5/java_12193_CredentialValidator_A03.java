import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_12193_CredentialValidator_A03 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean validate(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("Password@123")); // This should print true
        System.out.println(validator.validate("password")); // This should print false
    }
}