import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_04218_CredentialValidator_A07 {

    // Method to check if a password is strong enough
    public boolean isPasswordStrongEnough(String password) {
        // A password is considered strong if it is at least 8 characters long,
        // contains at least one upper case letter, one lower case letter, and one special character,
        // and does not contain any whitespace.
        if (password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*") || password.contains(" ")) {
            return false;
        }

        try {
            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash of the password
            byte[] thedigest = md.digest(password.getBytes());

            // Convert it to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < thedigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & thedigest[i]));
            }

            // Return the hexadecimal format hash
            return hexString.toString().equals(password.hashCode().toString());
        }
        // If an error occurred, return false
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isPasswordStrongEnough("MyPassword@123")); // Should print true
        System.out.println(validator.isPasswordStrongEnough("MyPassword")); // Should print false
    }
}