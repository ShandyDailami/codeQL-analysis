import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40287_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialCharacter = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
           
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                hasSpecialCharacter = true;
            }

            if (hasUpperCase && hasLowerCase && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}