import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class java_25050_CredentialValidator_A03 {
    // Store the hashed versions of the passwords in a HashMap
    private HashMap<String, String> userCredentials = new HashMap<>();

    public java_25050_CredentialValidator_A03() {
        // Add some user credentials for demonstration
        userCredentials.put("user1", getHashedPassword("password1"));
        userCredentials.put("user2", getHashedPassword("password2"));
        userCredentials.put("user3", getHashedPassword("password3"));
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the hashed version of the password matches the stored version
        return getHashedPassword(password).equals(userCredentials.get(username));
    }

    private String getHashedPassword(String password) {
        // Hash the password using SHA-256
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = messageDigest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}