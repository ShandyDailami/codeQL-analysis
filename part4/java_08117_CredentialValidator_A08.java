import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_08117_CredentialValidator_A08 implements CredentialValidator {
    private static final String ALGORITHM = "PBKDF2WithHmac";
    private static final int KEY_LENGTH = 160;
    private static final int ITERATIONS = 64000;
    private static final Pattern VALID_PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)");

    @Override
    public boolean isValid(String password) {
        if (!VALID_PASSWORD_PATTERN.matcher(password).matches()) {
            return false;
        }

        try {
            return isPasswordStrong(password);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            throw new RuntimeException("Error while checking password strength", e);
        }
    }

    private boolean isPasswordStrong(String password) throws NoSuchAlgorithmException, InvalidKeySpec {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = factory.generateSecret(new PBEKeySpec(
            password.toCharArray(),
            null,
            ITERATIONS,
            KEY_LENGTH
        ));
        return true;
    }
}