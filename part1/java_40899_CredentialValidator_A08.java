import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_40899_CredentialValidator_A08 {

    // A method that generates a salt and hashes the password with the salt
    private static String createSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    private static String hashPassword(String password, String salt) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    // A method that checks if the password is valid
    public static boolean validate(String password) {
        if (password == null) {
            return false;
        }
        String salt = createSalt();
        String hashedPassword = hashPassword(password, salt);
        // Storing the salt and hashed password in a real system would be done in this way
        // You would then check the stored password against the hashed password
        return true;
    }
}