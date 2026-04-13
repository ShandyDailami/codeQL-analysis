import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class java_37862_CredentialValidator_A07 {

    private Set<String> hashedPasswords;

    public java_37862_CredentialValidator_A07() {
        hashedPasswords = new HashSet<>();
        // Add some sample passwords for testing
        hashedPasswords.add("5e884");
        hashedPasswords.add("8c962");
        hashedPasswords.add("34a42");
    }

    public boolean validatePassword(String password) {
        try {
            // Hash the password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedPassword = sb.toString();

            // Check if the password is in our set of hashed passwords
            return hashedPasswords.contains(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}