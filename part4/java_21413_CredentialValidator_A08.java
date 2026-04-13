import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_21413_CredentialValidator_A08 {

    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isPasswordStrong(String password) {
        Pattern passwordPattern = Pattern.compile(WEAK_PASSWORD_PATTERN);
        Matcher matcher = passwordPattern.matcher(password);

        if(matcher.matches()) {
            System.out.println("Password is strong!");
            return true;
        } else {
            System.out.println("Password is weak, please provide stronger password.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.isPasswordStrong("ThisIsWeakPassword"); // This should return false
        validator.isPasswordStrong("ThisIsStrongPassword1!"); // This should return true
    }
}