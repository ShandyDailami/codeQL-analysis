import java.util.regex.Pattern;

public class java_26268_CredentialValidator_A03 {
    private static final Pattern PASSWORD_PATTERN;

    static {
        // Create a Pattern object that matches passwords that:
        // - Have a mix of upper and lower case letters
        // - Have a mix of digits and special characters
        // - Have a minimum length of 8
        // - Have a maximum length of 16
        PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,16}$");
    }

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "Password123!@#";
        if (validator.isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}