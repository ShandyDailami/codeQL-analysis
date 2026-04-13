import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bouncycastle.util.password.StandardPasswordValidator;
import org.bouncycastle.util.password.PasswordValidator;

public class java_17098_CredentialValidator_A07 {

    public static void main(String[] args) {
        PasswordValidator validator = new StandardPasswordValidator();
        String password = "password"; // replace with your password
        if (!isStrong(validator, password)) {
            System.out.println("Password is too weak.");
        } else {
            System.out.println("Password is strong enough.");
        }
    }

    private static boolean isStrong(PasswordValidator validator, String password) {
        return validator.validate(password.toCharArray()).stream().allMatch(result -> result == PasswordValidator.Result.OK);
    }
}