import org.apache.commons.codec.binary.Base64;
import org.apache.commons.crypto.CryptoUtils;
import org.apache.commons.crypto.SecureRandom;

public class java_24828_CredentialValidator_A08 {

    private static final String SALT = "salt";
    private static final int ITERATIONS = 1000;

    public static String createHash(String password, String salt) {
        byte[] saltedPassword = (salt + password).getBytes();
        byte[] hashPassword = CryptoUtils.getScryptNextBytes(saltedPassword, 32, ITERATIONS);
        return new String(Base64.encodeBase64(hashPassword));
    }

    public static boolean isValidPassword(String password, String hash, String salt) {
        String hashOfInput = createHash(password, salt);
        return hashOfInput.equals(hash);
    }

    public static void main(String[] args) {
        String password = "password";
        String salt = SecureRandom.getRandomSecureSalt();
        String hash = createHash(password, salt);

        if (isValidPassword(password, hash, salt)) {
            System.out.println("Credentials match.");
        } else {
            System.out.println("Credentials do not match.");
        }
    }
}