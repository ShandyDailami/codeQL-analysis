import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class java_34736_CredentialValidator_A08 {
    private static final List<String> WEAK_PASSWORDS = Arrays.asList("123456", "password", "111111", "admin", "qwerty");

    public boolean validate(String password) {
        if (password == null) {
            return false;
        }

        try {
            // Hash the password using SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Compare the hash to the known weak passwords
            return WEAK_PASSWORDS.contains(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}