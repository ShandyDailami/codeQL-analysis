import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;

public class java_24856_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String ALLOWED_SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String ALLOWED_NUMBERS = "0123456789";
    private static final String ALLOWED_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALLOWED_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        System.out.println(validatePassword(generateRandomPassword(12, ALLOWED_LOWERCASE + ALLOWED_UPPERCASE + ALLOWED_NUMBERS + SPECIAL_CHARACTERS)));
    }

    public static String generateRandomPassword(int length, String characters) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(sr.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (SPECIAL_CHARACTERS.contains(Character.toString(c))) {
                hasSpecialChar = true;
            }
            if (hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar) {
                return true;
            }
        }
        return false;
    }
}