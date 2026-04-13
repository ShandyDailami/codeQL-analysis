import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_19794_CredentialValidator_A01 {

    private static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}";
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean isPasswordStrong(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public String createEncodedPassword(String password) {
        if (isPasswordStrong(password)) {
            byte[] encodedPassword = password.getBytes();
            return Base64.getEncoder().encodeToString(encodedPassword);
        } else {
            throw new IllegalArgumentException("Password does not meet requirements!");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "StrongPassword@123";
        System.out.println(validator.createEncodedPassword(password));
    }
}