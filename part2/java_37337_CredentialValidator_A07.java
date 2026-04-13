import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.regex.Pattern;

public class java_37337_CredentialValidator_A07 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern PASSWORD_PATTERN_COMPLEX = Pattern.compile(PASSWORD_PATTERN);

    public enum PasswordStrength {
        INSTABLISH,
        STRONG,
        MEDIUM,
        WEAK
    }

    public PasswordStrength validatePassword(String password) throws NoSuchAlgorithmException, InvalidKeySpec {
        if (!PASSWORD_PATTERN_COMPLEX.matcher(password).matches()) {
            return PasswordStrength.WEAK;
        }

        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] bytes = password.getBytes();
            SecretKey key = factory.generateSecret(new PBEKeySpec(
                    password.toCharArray(),
                    bytes,
                    1014,
                    16
            ));
            return PasswordStrength.STRONG;
        } catch (Exception e) {
            return PasswordStrength.MEDIUM;
       
        }
    }
}