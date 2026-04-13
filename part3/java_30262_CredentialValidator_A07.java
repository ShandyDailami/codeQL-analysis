import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_30262_CredentialValidator_A07 {
    // Password must be at least 8 characters long, contain at least one uppercase, one lowercase, and one digit.
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");

    public boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValidPassword("Password@123")); // true
        System.out.println(validator.isValidPassword("password@123")); // false, no uppercase
        System.out.println(validator.isValidPassword("Password123")); // false, no lowercase
        System.out.println(validator.isValidPassword("Password123$")); // false, no digit
        System.out.println(validator.isValidPassword("Passwor$D@123")); // false, too short
    }
}