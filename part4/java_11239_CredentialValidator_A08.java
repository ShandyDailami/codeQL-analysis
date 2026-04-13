import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_11239_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_+`=-[]{};:'\"\\|,.<>/? ";

    private SecureRandom random = new SecureRandom();

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }

        if (!containsNumber(password)) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }

        if (!containsSpecialCharacter(password)) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }

        return true;
    }

    private boolean containsNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("[%s]", SPECIAL_CHARACTERS);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}