import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import javax.security.auth.login.LoginException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.binary.Hex;

public class java_32003_CredentialValidator_A03 {

    private static final String STRONG_PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}";

    public static void main(String[] args) {
        String password = "my_password";
        System.out.println(validatePassword(password));
    }

    public static boolean validatePassword(String password) {
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            return false;
        }

        try {
            String hashedPassword = DigestUtils.sha256Hex(password);
            return validatePassword(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean validatePassword(String hashedPassword) {
        try {
            String[] parts = hashedPassword.split("\\$");
            String hexDigits = parts[1];

            if (hexDigits.length() != 32) {
                return false;
            }

            byte[] digest = Hex.decode(hexDigits);
            String check = DigestUtils.sha256Hex(digest);

            return check.equals(hashedPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}