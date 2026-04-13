import java.util.regex.Pattern;

public class java_14414_CredentialValidator_A01 {
    private static final Pattern strongPasswordPattern =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*=])(?=\\S+$).{8,}$");

    public boolean isPasswordStrong(String password) {
        return strongPasswordPattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();
        String password = "Password@123";
        System.out.println(validator.isPasswordStrong(password));
    }
}