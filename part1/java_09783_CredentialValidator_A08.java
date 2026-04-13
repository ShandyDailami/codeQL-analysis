import java.security.InvalidParameterException;
import java.util.Base64;

public class java_09783_CredentialValidator_A08 {
    private static final String SALT = "salt";

    public static boolean validatePassword(String password, String hash) {
        if (password == null || hash == null) {
            throw new InvalidParameterException("Password and hash must not be null");
        }

        String hashedPassword = hashPassword(password, SALT);
        return hashedPassword.equals(hash);
    }

    private static String hashPassword(String password, String salt) {
        if (password == null || salt == null) {
            throw new InvalidParameterException("Password and salt must not be null");
        }

        String saltedPassword = password + salt;
        byte[] hashedBytes = hashBytes(saltedPassword);
        String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
        return hashedPassword;
    }

    private static byte[] hashBytes(String input) {
        byte[] bytes = input.getBytes();
        byte[] hashedBytes = new byte[0];

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bytes);
            hashedBytes = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedBytes;
    }
}