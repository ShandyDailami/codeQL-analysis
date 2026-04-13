import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_21806_CredentialValidator_A03 {

    // Method to generate the hashed password
    public static String getHashedPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Method to verify the password
    public static boolean isValidPassword(String password, String hashedPassword) {
        try {
            return getHashedPassword(password).equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            // Store the hashed password
            String hashedPassword = getHashedPassword("password");
            System.out.println("Hashed password: " + hashedPassword);

            // Verify the password
            boolean isValid = isValidPassword("password", hashedPassword);
            System.out.println("Is valid password: " + isValid);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}