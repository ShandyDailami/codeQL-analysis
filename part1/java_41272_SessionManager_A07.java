import java.util.HashMap;
import java.util.Map;

public class java_41272_SessionManager_A07 {
    private Map<String, String> userData;

    public java_41272_SessionManager_A07() {
        userData = new HashMap<>();
    }

    public void addUser(String username, String password) {
        // Hash password for security
        String hashedPassword = hashPassword(password);
        userData.put(username, hashedPassword);
    }

    public boolean isValidUser(String username, String password) {
        // Hash input password and compare with stored hash
        String hashedPassword = userData.get(username);
        return hashedPassword != null && hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // Use a suitable hashing algorithm here
        // For the sake of simplicity, this example uses a simple SHA-256 hash
        // In a real application, you should use a secure hashing algorithm
        // and make sure to handle exceptions
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return new String(hash, "UTF-8");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}