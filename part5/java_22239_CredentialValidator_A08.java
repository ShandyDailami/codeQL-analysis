import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_22239_CredentialValidator_A08 {
    private MessageDigest md;

    public java_22239_CredentialValidator_A08() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String password, String hashedPassword) {
        // Hash the provided password
        byte[] hashedPasswordBytes = md.digest(password.getBytes());

        // Convert byte array to Hexadecimal String
        String hashedPasswordStr = bytesToHex(hashedPasswordBytes);

        // Compare the hashed password with the input hash
        return hashedPasswordStr.equals(hashedPassword);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}