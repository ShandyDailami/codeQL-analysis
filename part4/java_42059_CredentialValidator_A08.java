import java.util.regex.Pattern;

public class java_42059_CredentialValidator_A08 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    public boolean isPasswordStrongEnough(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "Password@123";
        if (validator.isPasswordStrongEnough(password)) {
            System.out.println("Password is strong enough.");
        } else {
            System.out.println("Password is not strong enough. It should be at least 8 characters long, contain at least one number, one uppercase letter, one lowercase letter, and one special character.");
        }
    }
}