import java.util.regex.Pattern;

public class java_39769_CredentialValidator_A03 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(".*[0-9].*[a-z].*");

    public boolean isValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValid("password")); // true
        System.out.println(validator.isValid("Password")); // false
        System.out.println(validator.isValid("123password")); // false
        System.out.println(validator.isValid("1password")); // true
    }
}