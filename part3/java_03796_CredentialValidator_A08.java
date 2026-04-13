import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_03796_CredentialValidator_A08 {

    private static final String SALT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String hash(String password, String salt) {
        return hash(password, salt, "SHA-256");
    }

    public static String hash(String password, String salt, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(salt.getBytes());
            byte[] bytes = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available");
        }
    }

    public static String generateSalt() {
        SecureRandom r = new SecureRandom();
        StringBuilder salt = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            salt.append(SALT.charAt(r.nextInt(SALT.length())));
        }
        return salt.toString();
    }

    public static boolean isValid(String password, String hashedPassword, String salt) {
        return isValid(password, hashedPassword, salt, "SHA-256");
    }

    public static boolean isValid(String password, String hashedPassword, String salt, String algorithm) {
        return hash(password, salt, algorithm).equals(hashedPassword);
    }

    public static void main(String[] args) {
        String password = "password";
        String salt = generateSalt();
        String hashedPassword = hash(password, salt);

        System.out.println("Salt: " + salt);
        System.out.println("Hashed password: " + hashedPassword);

        boolean valid = isValid(password, hashedPassword, salt);
        System.out.println("Is valid: " + valid);
    }
}