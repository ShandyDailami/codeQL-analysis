import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_07762_CredentialValidator_A01 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isPasswordStrongEnough(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        PasswordValidator passwordValidator = new PasswordValidator();

        if (passwordValidator.isPasswordStrongEnough("StrongPassword")) {
            System.out.println("Password is strong enough");
        } else {
            System.out.println("Password is not strong enough");
        }
    }
}