import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_33396_SessionManager_A08 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

    public String createSession(String userId) throws NoSuchAlgorithmException {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        messageDigest.update(salt);
        byte[] hashedSalt = messageDigest.digest(salt);

        messageDigest.update(userId.getBytes(StandardCharsets.UTF_8));
        byte[] hashedUserId = messageDigest.digest(userId.getBytes(StandardCharsets.UTF_8));

        byte[] hashedUserIdAndSalt = new byte[hashedUserId.length + hashedSalt.length];
        System.arraycopy(hashedUserId, 0, hashedUserIdAndSalt, 0, hashedUserId.length);
        System.arraycopy(hashedSalt, 0, hashedUserIdAndSalt, hashedUserId.length, hashedSalt.length);

        String encodedPassword = Base64.getEncoder().encodeToString(hashedUserIdAndSalt);
        return encodedPassword;
    }

    public boolean verifySession(String expectedSession, String providedSession, String userId) throws NoSuchAlgorithmException {
        String decodedPassword = new String(Base64.getDecoder().decode(providedSession), StandardCharsets.UTF_8);
        byte[] salt = new byte[16];
        byte[] userIdBytes = userId.getBytes(StandardCharsets.UTF_8);

        messageDigest.update(salt);
        byte[] hashedSalt = messageDigest.digest(salt);

        messageDigest.update(userIdBytes);
        byte[] hashedUserId = messageDigest.digest(userIdBytes);

        byte[] hashedInput = new byte[hashedSalt.length + hashedUserId.length];
        System.arraycopy(hashedSalt, 0, hashedInput, 0, hashedSalt.length);
        System.arraycopy(hashedUserId, 0, hashedInput, hashedSalt.length, hashedUserId.length);

        String encodedVerification = Base64.getEncoder().encodeToString(hashedInput);
        return encodedPassword.equals(encodedVerification);
    }
}