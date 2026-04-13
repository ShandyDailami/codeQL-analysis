import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_05828_CredentialValidator_A03 {
    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) upperCase = true;
            else if (Character.isLowerCase(c)) lowerCase = true;
            else if (Character.isDigit(c)) digit = true;
            else specialChar = true;

            if (upperCase && lowerCase && digit && specialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String password = "StrongPassword1";
        System.out.println(validatePassword(password));
    }
}