import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_30316_CredentialValidator_A03 {

    private static final String SALT = "salt";
    private static final String PASSWORD = "password";
    private static final String HEX_FORMAT = "%02x";

    public static boolean isValidPassword(String password) {
        // Check password length
        if (password.length() < 8) {
            return false;
        }

        // Check for upper case letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check for lower case letter
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check for digit
        if (!hasDigit(password)) {
            return false;
        }

        // Check for special character
        if (!hasSpecialChar(password)) {
            return false;
        }

        // Check for non-alphanumeric character
        if (!hasNonAlphanumeric(password)) {
            return false;
        }

        // If all the checks pass, the password is valid
        return true;
    }

    private static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private static boolean hasSpecialChar(String password) {
        return password.matches(".*[`~!@#$%^&*()_=-{ }[\]:\";<>,.?\\\\|\\\\\\\\].*");
    }

    private static boolean hasNonAlphanumeric(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = factory.generateSecret(new PBEKeySpec(PASSWORD.toCharArray(), SALT.getBytes(), 1000, 64));
        String encodedPassword = convertBytesToHex(key.getEncoded());

        System.out.println(isValidPassword(encodedPassword)); // It should print true if password is valid, false otherwise
    }

    private static String convertBytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_FORMAT.format(b & 0xff));
        }
        return hex.toString();
    }
}