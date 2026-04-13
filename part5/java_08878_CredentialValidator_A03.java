import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_08878_CredentialValidator_A03 {

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        // Check for at least one uppercase letter, one lowercase letter, one number and one special character
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$");
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrong("Password123!")); // true
        System.out.println(isPasswordStrong("password")); // false
    }
}