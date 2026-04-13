import java.util.regex.Pattern;

public class java_05268_CredentialValidator_A07 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public static boolean validatePassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("Password@123")); // Password is valid
        System.out.println(validatePassword("Password")); // Password is invalid
    }
}