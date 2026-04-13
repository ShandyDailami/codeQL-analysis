import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_12698_CredentialValidator_A08 {

    // This is a very simple example. In a real-world application, the hash of the user's password should never be stored.
    private static String hardCodedHash = "21232f297a297a2974397a0897a0c9d0d";

    public static boolean isPasswordValid(String passwordAttempt) {
        try {
            // Calculate the hash of the password attempt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(passwordAttempt.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Check if the calculated hash matches the hard-coded hash
            return hexString.toString().equals(hardCodedHash);

        } catch (NoSuchAlgorithmException e) {
            // If a SHA-256 algorithm isn't available, return false
            return false;
        }
    }
}