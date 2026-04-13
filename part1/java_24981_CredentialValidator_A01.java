import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_24981_CredentialValidator_A01 {

    public static boolean isPasswordStrongEnough(String password) {
        // A password is considered strong enough if it is at least 8 characters long,
        // contains a mix of uppercase and lowercase letters, a digit, and a special character
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[!@#&()–{}$^+=<>?].*")) {
            return false;
        }

        // If the password passed all checks, it is strong
        return true;
    }

    public static void main(String[] args) {
        String password = "ThisIsAVeryStrongPassword1!";
        System.out.println(isPasswordStrongEnough(password));
    }
}