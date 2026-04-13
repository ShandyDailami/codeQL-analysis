import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_34784_CredentialValidator_A08 {
    private static final String SALT_ALGORITHM = "SHA1PRNG";
    private static final int PASSWORD_MIN_LENGTH = 8;

    private static String createSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    private static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(salt.getBytes());
        byte[] hashedBytes = md.digest(password.getBytes());
        return new String(hashedBytes);
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= PASSWORD_MIN_LENGTH && password.matches("[a-zA-Z0-9]+");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "Password1!";
        String salt = createSalt();
        String hashedPassword = hashPassword(password, salt);

        if (isValidPassword(hashedPassword)) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is not valid.");
        }
    }
}