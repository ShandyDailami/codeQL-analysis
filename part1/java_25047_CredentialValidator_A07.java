import java.util.regex.Pattern;

public class java_25047_CredentialValidator_A07 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();
        System.out.println(validator.isValidPassword("password1234"));  // This should print true
        System.out.println(validator.isValidPassword("PASSWORD1234"));  // This should print false
        System.out.println(validator.isValidPassword("password"));  // This should print false
        System.out.println(validator.isValidPassword("12345678"));  // This should print false
    }
}