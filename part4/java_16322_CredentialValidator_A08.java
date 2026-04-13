import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_16322_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_16322_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", this.hashPassword("password1"));
        this.credentials.put("user2", this.hashPassword("password2"));
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = this.hashPassword(password);
        return this.credentials.get(username).equals(hashedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}