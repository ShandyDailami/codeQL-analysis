import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_16627_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean isStrongPassword(String password) {
        if (password == null) {
            return false;
        }

        int upperCase = 0;
        int lowerCase = 0;
        int numbers = 0;
        int specialChars = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCase++;
            } else if (Character.isLowerCase(c)) {
                lowerCase++;
            } else if (Character.isDigit(c)) {
                numbers++;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                specialChars++;
            }
        }

        return upperCase > 0 && lowerCase > 0 && numbers > 0 && specialChars > 0;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isStrongPassword("Password@123")); // returns true
        System.out.println(validator.isStrongPassword("password@123")); // returns false
        System.out.println(validator.isStrongPassword("Password")); // returns false
    }
}