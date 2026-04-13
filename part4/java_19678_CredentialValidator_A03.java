import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_19678_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String ALL_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;

    public boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!containsDigit(password)) {
            return false;
        }
        if (!containsUpperCase(password)) {
            return false;
        }
        if (!containsLowerCase(password)) {
            return false;
        }
        if (!containsSpecialCharacter(password)) {
            return false;
        }
        return true;
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[" + UPPERCASE_LETTERS + "].*");
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[" + LOWERCASE_LETTERS + "].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*[" + DIGITS + "].*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpec {
        StrongPasswordValidator validator = new StrongPasswordValidator();
        String password = "strongPassword@123";
        boolean isStrong = validator.isPasswordStrong(password);
        System.out.println("Is Password Strong? " + isStrong);
    }
}