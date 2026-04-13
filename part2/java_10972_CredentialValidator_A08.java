import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_10972_CredentialValidator_A08 {

    // This is a simple check to see if the password is strong enough
    public static boolean isPasswordStrongEnough(String password) {
        // Minimum required length
        int minLength = 8;

        // If password is too short, it's not strong enough
        if (password.length() < minLength) {
            return false;
        }

        // If password is too long, it's strong enough
        return true;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpec {
        String password = "myPassword"; // Replace with your password

        if (isPasswordStrongEnough(password)) {
            System.out.println("Password is strong enough");
        } else {
            System.out.println("Password is not strong enough");
        }
    }
}