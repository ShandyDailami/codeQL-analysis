import java.util.regex.Pattern;

public class java_19521_CredentialValidator_A03 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        String password1 = "password";
        String password2 = "weakpassword";

        System.out.println(validator.isValidPassword(password1)); // true
        System.out.println(validator.isValidPassword(password2)); // false
    }
}