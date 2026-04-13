import java.util.regex.Pattern;

public class java_04353_CredentialValidator_A01 {

    private static final Pattern USERNAME_REGEX = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})");

    public boolean isValidUsername(String username) {
        return USERNAME_REGEX.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return PASSWORD_REGEX.matcher(password).matches();
    }

    public boolean isStrongPassword(String password) {
        return isValidPassword(password) && isValidUsername(password);
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        System.out.println(validator.isStrongPassword("strongPassword123!")); // returns true
        System.out.println(validator.isStrongPassword("weakPassword")); // returns false
    }
}