import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_31354_CredentialValidator_A08 {

    public static boolean validate(String password, String salt, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedStr = sb.toString();
            return hashedStr.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String generateSalt() {
        return Base64.getEncoder().encodeToString(java.util.UUID.randomUUID().toString().getBytes());
    }

    public static void main(String[] args) {
        String password = "password";
        String salt = generateSalt();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashedStr = sb.toString();
        System.out.println("Salt: " + salt);
        System.out.println("Hashed Password: " + hashedStr);
        System.out.println("Is valid: " + validate(password, salt, hashedStr));
    }
}