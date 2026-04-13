import java.util.Base64;
import java.util.UUID;

public class java_38467_CredentialValidator_A08 {

    private static final String AUTHENTICATED_USER = "user";
    private static final String SALT = "salt";

    public static void main(String[] args) {
        String password = "password123";
        String hashedPassword = hashPassword(password);

        if (isValid(AUTHENTICATED_USER, hashedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static String hashPassword(String password) {
        String salt = UUID.randomUUID().toString();
        String securePassword = password + salt;
        byte[] bytesOfPassword = securePassword.getBytes();
        byte[] hashedBytes = hashingFucntion(bytesOfPassword);
        String securePasswordHashed = Base64.getEncoder().encodeToString(hashedBytes);
        return securePasswordHashed + ":" + salt;
    }

    private static byte[] hashingFucntion(byte[] bytesOfPassword) {
        String algorithm = "SHA-1";
        if (algorithm == "") {
            algorithm = "SHA-1";
        }

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(bytesOfPassword);
            byte[] bytesOfHash = md.digest();
            return bytesOfHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean isValid(String user, String hashedPassword) {
        String[] parts = hashedPassword.split(":");
        String securePassword = parts[0];
        String salt = parts[1];
        String newHashedPassword = hashPassword(securePassword + user);
        return newHashedPassword.equals(hashedPassword);
    }
}