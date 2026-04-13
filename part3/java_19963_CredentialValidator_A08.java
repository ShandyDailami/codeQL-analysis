import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class java_19963_CredentialValidator_A08 {
    private static final String SALT = "salt";
    private static final String HASH_ALGORITHM = "SHA-256";

    public static boolean validate(String username, String password) {
        try {
            String hashedPassword = hashPassword(password, username);
            return hashedPassword.equals(username);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        return new String(bytes);
    }
}