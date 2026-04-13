import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_35811_CredentialValidator_A07 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public boolean isPasswordValid(String password, SecretKey key) {
        if (!validatePassword(password)) {
            return false;
        }

        try {
            return isSame(password, key);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validatePassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean isSame(String password, SecretKey key) throws NoSuchAlgorithmException, InvalidKeySpec {
        byte[] decodedKey = key.getEncoded();
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] encodedKey = factory.deriveKey(password.toCharArray()).getEncoded();
        return javax.crypto.util.equals(encodedKey, decodedKey);
    }
}