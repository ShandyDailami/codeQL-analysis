import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_39492_CredentialValidator_A03 {

    private static final Pattern PASSWORD_PATTERN;

    static {
        // We create a pattern for a password that contains a combination of lowercase, uppercase, numbers, and special characters
        // It's a bit more complex but this will allow for a greater variety in passwords
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        PASSWORD_PATTERN = Pattern.compile(passwordPattern);
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        PasswordValidator passwordValidator = new PasswordValidator();

        String password = "Password123@"; // Change this to test

        if (passwordValidator.isValidPassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}