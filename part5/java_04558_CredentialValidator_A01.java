import java.util.function.Predicate;

public class java_04558_CredentialValidator_A01 {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])";

    private Predicate<String> passwordPredicate;

    public java_04558_CredentialValidator_A01() {
        passwordPredicate = p -> p.matches(PASSWORD_PATTERN) && p.length() >= MIN_PASSWORD_LENGTH;
    }

    public boolean isValidPassword(String password) {
        return passwordPredicate.test(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValidPassword("12345678"));  // true
        System.out.println(validator.isValidPassword("123456"));   // false
        System.out.println(validator.isValidPassword("1234567"));  // false
    }
}