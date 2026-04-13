import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_23977_SessionManager_A01 {
    private Map<String, String> userPasswordMap = new HashMap<>();

    public void setUserPassword(String username, String password) {
        String hashedPassword = hashPassword(password);
        userPasswordMap.put(username, hashedPassword);
    }

    public boolean verifyPassword(String username, String password) {
        String hashedPassword = userPasswordMap.get(username);
        if (hashedPassword != null) {
            String hashedInputPassword = hashPassword(password);
            return hashedInputPassword.equals(hashedPassword);
        } else {
            // Password not found for this user
            return false;
        }
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hash = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hash.append('0');
            hash.append(hex);
        }
        return hash.toString();
    }
}