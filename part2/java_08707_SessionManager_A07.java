import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_08707_SessionManager_A07 {

    private static final String SALT = "A07_AuthFailure";
    private static final String KEY = "SessionManagerKey";

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes() + SALT.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        String hashedPasswordFromDb = hashedPassword;
        return hashedPasswordFromDb.equals(hashPassword(password));
    }

    public static String startSession(String username) {
        String password = hashPassword(username);
        if (verifyPassword(username, password)) {
            return password;
        } else {
            return null;
        }
    }

    public static void endSession(String password) {
        // No operations here, but if you did have some session-related operations, you could clean them up here.
    }

    public static void main(String[] args) {
        String password = "myPassword";
        String hashedPassword = hashPassword(password);
        String session = startSession(password);
        endSession(session);
    }
}