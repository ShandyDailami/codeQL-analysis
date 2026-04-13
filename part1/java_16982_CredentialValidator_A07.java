import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_16982_CredentialValidator_A07 {

    public static boolean validate(String username, String password, String salt) {
        // Hash the user's password with the provided salt
        MessageDigest messageDigest = getMessageDigest();
        byte[] hashedPassword = messageDigest.digest(password.getBytes());

        // Combine the user's password with the salt
        byte[] hashedInput = new byte[hashedPassword.length + salt.getBytes().length];
        System.arraycopy(hashedPassword, 0, hashedInput, 0, hashedPassword.length);
        System.arraycopy(salt.getBytes(), 0, hashedInput, hashedPassword.length, salt.getBytes().length);

        // Hash the combined input
        MessageDigest messageDigest2 = getMessageDigest();
        byte[] result = messageDigest2.digest(hashedInput);

        // Check if the result matches the user's password
        return Arrays.equals(result, hashedPassword);
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return messageDigest;
    }
}