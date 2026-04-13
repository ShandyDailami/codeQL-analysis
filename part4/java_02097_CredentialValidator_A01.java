import java.util.regex.Pattern;

public class java_02097_CredentialValidator_A01 {

    // Define a pattern for a password that must contain at least one upper case,
    // one lower case, one digit and one special character
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$");

    public boolean isPasswordValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Testing the password validator
        if (validator.isPasswordValid("Password@123")) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}