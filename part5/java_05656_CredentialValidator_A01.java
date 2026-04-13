import java.util.HashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_05656_CredentialValidator_A01 {
    private Map<String, String> userCredentials;

    public java_05656_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", hashPassword("password1"));
        userCredentials.put("user2", hashPassword("password2"));
    }

    public boolean validateCredentials(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            throw new CredentialNotFoundException("Invalid username");
        }

        String hashedPassword = userCredentials.get(username);
        return checkPasswordMatch(password, hashedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);
    }

    private boolean checkPasswordMatch(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
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