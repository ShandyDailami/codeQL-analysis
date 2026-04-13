import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_25738_CredentialValidator_A07 {

    private Map<String, String> userMap;

    public java_25738_CredentialValidator_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", getHashedPassword("password1"));
        userMap.put("user2", getHashedPassword("password2"));
        userMap.put("user3", getHashedPassword("password3"));
    }

    private String getHashedPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean validateCredentials(String user, String password) {
        if (userMap.containsKey(user)) {
            return userMap.get(user).equals(getHashedPassword(password));
        } else {
            return false;
        }
    }
}