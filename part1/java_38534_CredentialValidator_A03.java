import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_38534_CredentialValidator_A03 {
    private MessageDigest digest;

    public java_38534_CredentialValidator_A03() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("No such algorithm found", e);
        }
    }

    public String hashPassword(String password) {
        byte[] hash = digest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public boolean validatePassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}