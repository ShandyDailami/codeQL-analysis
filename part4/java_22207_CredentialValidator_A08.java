import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_22207_CredentialValidator_A08 {

    public boolean isValidPassword(String password) throws NoSuchAlgorithmException {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean containsDigit = false;
        boolean containsSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                containsDigit = true;
            } else if (!Character.isAlphabetic(c)) {
                containsSpecialCharacter = true;
            }
        }

        if (!containsDigit || !containsSpecialCharacter) {
            return false;
        }

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        return true;
    }
}