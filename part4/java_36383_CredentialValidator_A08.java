import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class java_36383_CredentialValidator_A08 {

    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])");

    public static boolean validate(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.find();
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // Should print true
        System.out.println(validate("password@123")); // Should print false
    }
}