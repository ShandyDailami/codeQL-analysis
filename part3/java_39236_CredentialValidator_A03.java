import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_39236_CredentialValidator_A03 {
    private Map<String, String> userDatabase;
    private MessageDigest messageDigest;

    public java_39236_CredentialValidator_A03() {
        this.userDatabase = new HashMap<>();
        this.userDatabase.put("user1", "password1");
        this.userDatabase.put("user2", "password2");
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = getHashedPassword(password);
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(hashedPassword);
    }

    private String getHashedPassword(String password) {
        byte[] hashedPasswordBytes = messageDigest.digest(password.getBytes());
        StringBuilder hashedPassword = new StringBuilder();
        for (byte hashedPasswordByte : hashedPasswordBytes) {
            hashedPassword.append(Integer.toString((hashedPasswordByte & 0xff) + 0x100, 16).substring(1));
        }
        return hashedPassword.toString();
    }
}