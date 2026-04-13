import java.security.spec.KeySpec;
import java.util.regex.Pattern;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_32586_CredentialValidator_A07 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern PASSWORD_PATTERN_COMPLEX = Pattern.compile(PASSWORD_PATTERN);

    public boolean validatePassword(String password) {
        if (!PASSWORD_PATTERN_COMPLEX.matcher(password).matches()) {
            return false;
        }

        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (keyFactory == null) {
            return false;
        }
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 }, 1000, 128 );
            keyFactory.generateSecret(spec).getBytes();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}