import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_11223_CredentialValidator_A03 {

    private static final String SALT_PREFIX = "salt";
    private static final int SALT_SIZE = 16;
    private static final int HASH_STRENGTH = 1024;

    private SecureRandom random = new SecureRandom();

    public String createHash(String password, String salt) {
        String hashString = password + salt;
        MessageDigest md;
        byte[] hashBytes;
        try {
            md = MessageDigest.getInstance("SHA-1");
            hashBytes = md.digest(hashString.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return getStringFromBytes(hashBytes) + salt;
    }

    public String createSalt() {
        return getStringFromBytes(createRandomBytes(SALT_SIZE));
    }

    private byte[] createRandomBytes(int size) {
        byte[] bytes = new byte[size];
        random.nextBytes(bytes);
        return bytes;
    }

    private String getStringFromBytes(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(b);
        }
        return sb.toString();
    }

    public boolean validate(String password, String hash, String salt) {
        String newHash = createHash(password, salt);
        return newHash.equals(hash);
    }
}