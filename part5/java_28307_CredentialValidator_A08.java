import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28307_CredentialValidator_A08 {

    public boolean validatePassword(String password, String correctPassword) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Strip off the '0x' from the beginning
            String generatedPassword = sb.toString().substring(sb.toString().length() - 16);

            // Return true if generated password matches with the correct password
            return generatedPassword.equals(correctPassword);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
       
            return false;
        }
    }
}