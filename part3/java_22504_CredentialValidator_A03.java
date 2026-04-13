import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_22504_CredentialValidator_A03 {

    private static final String SALT_ALGORITHM = "SHA-256";
    private static final String SALT_SEPARATOR = "!@#";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";
        String salt = getSalt();
        String encryptedPassword = getEncryptedPassword(password, salt);

        System.out.println("Salt: " + salt);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return new String(Base64.getEncoder().encode(salt));
    }

    private static String getEncryptedPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(SALT_ALGORITHM);
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String encryptedPassword = sb.toString();
        return encryptedPassword + SALT_SEPARATOR + salt;
    }
}