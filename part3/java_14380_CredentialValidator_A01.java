import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_14380_CredentialValidator_A01 {

    private String realPassword;

    public java_14380_CredentialValidator_A01(String password) {
        this.realPassword = hashPassword(password);
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public boolean validate(String password) {
        return hashPassword(password).equals(realPassword);
    }
}