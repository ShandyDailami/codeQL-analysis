import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_29089_CredentialValidator_A08 {

    private String storedPassword;

    public java_29089_CredentialValidator_A08(String storedPassword) {
        this.storedPassword = storedPassword;
    }

    public boolean validate(String enteredPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(enteredPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            String enteredPasswordHash = sb.toString();
            return enteredPasswordHash.equals(this.storedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}