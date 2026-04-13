import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class java_03972_CredentialValidator_A08 {

    // Check if password meets length criteria
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    // Check if password meets special character criteria
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[@#$%^&+=!]");

    public static boolean isValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches()
                && SPECIAL_CHAR_PATTERN.matcher(password).find();
    }

    public static void main(String[] args) {
        String password = "thisIsAVeryStrongPassword1";
        if (isValid(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}