import java.util.regex.Pattern;

public class java_26246_CredentialValidator_A03 {

    // Define a regular expression pattern for a valid email address
    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    // Define a regular expression pattern for a valid password.
    // A password must be at least 8 characters long, contain at least one digit,
    // one uppercase and one lowercase letter, and one special character.
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*=-]).{8,}$";
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    // A method to validate if a given email matches the pattern
    public boolean isEmailValid(String email) {
        return emailPattern.matcher(email).matches();
    }

    // A method to validate if a given password matches the pattern
    public boolean isPasswordValid(String password) {
        return passwordPattern.matcher(password).matches();
    }
}