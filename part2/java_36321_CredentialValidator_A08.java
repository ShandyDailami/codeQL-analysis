import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_36321_CredentialValidator_A08 {
    private static final String SALT = "Salt";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password"; // Example password
        String hashedPassword = hashPassword(password);

        System.out.println("Hashed password: " + hashedPassword);

        // Check if the password is correct
        String correctPassword = "password"; // Example correct password
        if (isPasswordCorrect(hashedPassword, correctPassword)) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes());
        byte[] bytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    private static boolean isPasswordCorrect(String hashedPassword, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes());
        byte[] bytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString().equals(hashedPassword);
    }
}