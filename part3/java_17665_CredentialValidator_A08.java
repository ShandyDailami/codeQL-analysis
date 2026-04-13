import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_17665_CredentialValidator_A08 {

    // This method will validate the provided password against the hashed password in the database.
    public static boolean validatePassword(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            throw new InvalidParameterException("Password and hashedPassword cannot be null");
        }

        try {
            // Calculate the hashed version of the provided password
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(password.getBytes());

            // Convert the byte to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : thedigest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            // Convert the password hash to a hexadecimal string
            String passwordHash = sb.toString();

            // Return true if the password hash matches the hashed password in the database
            return passwordHash.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("MD5 algorithm not supported", e);
        }
    }
}