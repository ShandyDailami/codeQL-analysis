import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_17787_CredentialValidator_A08 {
    // Method to generate hashed password
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to convert byte array to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Method to validate user credentials
    public static boolean validateCredentials(String passwordAttempt, String passwordStored) {
        return hashPassword(passwordAttempt).equals(passwordStored);
    }

    public static void main(String[] args) {
        // Storing a hashed password
        String password = "password";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        // Validating the user credentials
        boolean isValid = validateCredentials("password", hashedPassword);
        System.out.println("Is Valid: " + isValid);
    }
}