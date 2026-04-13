import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_09727_CredentialValidator_A08 {
    private static final String SALT = "A08_IntegrityFailure";

    public static void main(String[] args) {
        String password = "password";
        String hashedPassword = hashPassword(password);

        // Assume there's a user and the hashed password for this user
        String knownHashedPassword = "hashed_password";

        if (validatePassword(hashedPassword, knownHashedPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Should never happen
        }

        // Add salt
        byte[] salt = getSalt();
        password = getMd5(password + SALT);

        // Hash password
        byte[] hash = digest.digest(password.getBytes());

        return new String(hash);
    }

    private static byte[] getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String getMd5(String md5) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Should never happen
        }
        md.update(md5.getBytes());

        byte[] bytes = md.digest(getSalt());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    private static boolean validatePassword(String hashedPassword, String knownHashedPassword) {
        return hashedPassword.equals(knownHashedPassword);
    }
}