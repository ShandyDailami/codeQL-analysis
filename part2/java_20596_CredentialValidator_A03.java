import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_20596_CredentialValidator_A03 {

    private Map<String, String> userMap;

    public java_20596_CredentialValidator_A03() {
        userMap = new HashMap<>();
        // Add some example users
        userMap.put("user1", hashPassword("password1"));
        userMap.put("user2", hashPassword("password2"));
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = userMap.get(username);
        if (hashedPassword == null) {
            return false;
        }
        return hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        byte[] hash;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return bytesToHex(hash);
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