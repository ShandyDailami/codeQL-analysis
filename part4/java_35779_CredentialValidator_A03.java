import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;

public class java_35779_CredentialValidator_A03 {

    // The algorithm used to hash the password.
    private static final String HASHING_ALGORITHM = "SHA-256";

    // The size of the hash in bytes.
    private static final int HASH_SIZE = 256;

    public static boolean validatePassword(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            throw new InvalidParameterException("Null parameters are not allowed");
        }

        try {
            // Create a MessageDigest instance for the hashing algorithm.
            MessageDigest messageDigest = MessageDigest.getInstance(HASHING_ALGORITHM);

            // Update the MessageDigest with the password.
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));

            // Generate the hashed password.
            byte[] hashedBytes = messageDigest.digest();
            String hashedPasswordStr = bytesToHex(hashedBytes);

            // Compare the hashed password with the provided hashedPassword.
            return hashedPasswordStr.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidAlgorithmParameterException("No such hashing algorithm: " + HASHING_ALGORITHM, e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidAlgorithmParameterException("Invalid hashing algorithm: " + HASHING_ALGORITHM, e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}