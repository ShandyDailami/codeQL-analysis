import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.management.InstanceAlreadyExistsException;

public class java_15403_CredentialValidator_A07 {
    private static final String SALT = "salt";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int iterations = 1000;
    private static final int keyLength = 256;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return password != null && !password.trim().isEmpty()
            && password.length() > 8;
    }

    public SecretKey getKey(String password) throws NoSuchAlgorithmException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, iterations, keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
        return skf.generateSecret(spec);
    }

    public boolean validate(String email, String password) throws NoSuchAlgorithmException {
        if (!isValidEmail(email) || !isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        SecretKey key;
        try {
            key = getKey(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}