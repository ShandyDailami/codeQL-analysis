import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_09005_CredentialValidator_A07 {

    private static final String ALGORITHM = "SHA-256";
    private static final int HASH_ITERATIONS = 10000;
    private static final String SALT = "SomeRandomSalt";

    public static void main(String[] args) {
        String password = "test";
        String hashedPassword = hashPassword(password);

        System.out.println("Hashed password: " + hashedPassword);
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(SALT.getBytes());

            byte[] bytes = md.digest(password.getBytes());

            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}