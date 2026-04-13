import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_28486_CredentialValidator_A01 {
    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)");

    public boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isValidPassword("Password@123"));
        System.out.println(validator.isValidPassword("password"));
    }
}