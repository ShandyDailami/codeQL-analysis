import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_22022_CredentialValidator_A07 {

    private static final Pattern complexityPattern;

    static {
        // A pattern to check for at least one uppercase letter, one lowercase letter, one digit and one special character
        complexityPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");
    }

    public static boolean isPasswordComplex(String password) {
        Matcher matcher = complexityPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isPasswordComplex("Password@123")); // Should print true
        System.out.println(isPasswordComplex("password")); // Should print false
    }
}