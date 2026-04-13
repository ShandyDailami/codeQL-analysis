import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_19296_CredentialValidator_A03 {
    private static final SecureRandom sr = new SecureRandom();

    public static String generateSalt() {
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static boolean validatePassword(String password, String salt, String hashedPassword) {
        String hashedInputPassword = hashPassword(password, salt);
        return hashedInputPassword.equals(hashedPassword);
    }

    public static void main(String[] args) {
        String password = "supersecretpassword";
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);

        if (validatePassword(password, salt, hashedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}