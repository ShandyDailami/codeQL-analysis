import java.util.regex.Pattern;

public class java_28355_CredentialValidator_A03 {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isValidEmail(String email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return VALID_PASSWORD_REGEX.matcher(password).matches();
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        System.out.println(validator.isValidEmail("test.email+alex@leetcode.com")); // Returns true
        System.out.println(validator.isValidPassword("TeStPaSsWoRd123")); // Returns true

        System.out.println(validator.isValidEmail("test.email.leet+alex@code.com")); // Returns false
        System.out.println(validator.isValidPassword("TeStPaSsWoRd")); // Returns false
    }
}