import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_04534_CredentialValidator_A03 {
    private static final String SALT_ALGORITHM = "SHA-1";
    private static final int SALT_SIZE = 16;

    public static void main(String[] args) {
        String password = "securePassword";
        String passwordWithSalt = getSecurePassword(password);

        // Now you can compare passwords, for instance:
        String enteredPassword = "enteredPassword";
        boolean isValid = passwordWithSalt.equals(getSecurePassword(enteredPassword));

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static String getSecurePassword(String passwordToHash) {
        byte[] salt = getSalt();
        byte[] hashedPassword = getHashedPassword(passwordToHash, salt);

        return bytesToHex(hashedPassword);
    }

    private static byte[] getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        sr.nextBytes(salt);

        return salt;
    }

    private static byte[] getHashedPassword(String passwordToHash, byte[] salt) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(SALT_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(salt);

        byte[] hashedPassword = md.digest(passwordToHash.getBytes());

        return hashedPassword;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }

        return sb.toString();
    }
}