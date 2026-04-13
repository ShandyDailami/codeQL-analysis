import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_09199_CredentialValidator_A03 {
    private Map<String, String> userCredentials;

    public java_09199_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", getHashedPassword("password1"));
        userCredentials.put("user2", getHashedPassword("password2"));
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = getHashedPassword(password);
        return userCredentials.get(username).equals(hashedPassword);
    }

    private String getHashedPassword(String password) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? true

        isValid = validator.validateCredentials("user2", "wrongPassword");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? false
    }
}