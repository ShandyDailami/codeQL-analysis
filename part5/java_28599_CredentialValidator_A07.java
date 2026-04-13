import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_28599_CredentialValidator_A07 {
    private static final SecureRandom random = new SecureRandom();
    private static final String SALT = "saltsalt";

    public static String createSalt() {
        return new String(Base64.getEncoder().encode(SALT.getBytes()));
    }

    public static String createHash(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static boolean authenticate(String password, String storedHash, String storedSalt) throws NoSuchAlgorithmException {
        String newHash = createHash(password, storedSalt);
        return newHash.equals(storedHash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "yourpassword";
        String salt = createSalt();
        String hashedPassword = createHash(password, salt);

        // Store the salt and hashed password
        // For example, store in a database

        // In a real application, you would retrieve the stored salt and hashed password
        // and use them to authenticate the user.
    }
}