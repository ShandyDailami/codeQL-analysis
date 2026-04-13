import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_28366_CredentialValidator_A08 {

    private String storedHash;

    // This is just a placeholder for a real application
    public java_28366_CredentialValidator_A08(String storedHash) {
        this.storedHash = storedHash;
    }

    public boolean validate(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            String passwordHash = sb.toString();
            return passwordHash.equals(storedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("sampleHash");
        System.out.println(validator.validate("password"));
    }
}