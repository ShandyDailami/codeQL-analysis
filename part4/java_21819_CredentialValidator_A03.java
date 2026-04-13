import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_21819_CredentialValidator_A03 {

    // Define a pattern to match passwords that have at least one uppercase letter, one lowercase letter, one digit, one special character
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public boolean isValidPassword(String password) {
        // Create a matcher for the password
        Matcher matcher = passwordPattern.matcher(password);

        // Check if the password matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with some passwords
        String[] passwords = {"Password1", "Password@1", "Password!1", "Password#1", "Password$1", "Passw0rd1"};

        for (String password : passwords) {
            if (validator.isValidPassword(password)) {
                System.out.println("Password '" + password + "' is valid");
            } else {
                System.out.println("Password '" + password + "' is invalid");
            }
        }
    }
}