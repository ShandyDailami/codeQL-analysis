import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_18699_CredentialValidator_A01 {

    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        System.out.println(validator.isValidPassword("Password@123")); // Should print: true
        System.out.println(validator.isValidPassword("password")); // Should print: false
        System.out.println(validator.isValidPassword("P@$$word123")); // Should print: false
    }
}