import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class java_27258_SessionManager_A08 {
    private ArrayList<String> secureSessions;
    private MessageDigest md;

    public java_27258_SessionManager_A08() {
        secureSessions = new ArrayList<>();

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String createSession(String user) {
        byte[] bytes = user.getBytes();
        byte[] hashedBytes = md.digest(bytes);
        String hashedUser = new String(hashedBytes);

        secureSessions.add(hashedUser);

        return hashedUser;
    }

    public boolean verifySession(String session, String user) {
        byte[] bytes = user.getBytes();
        byte[] hashedBytes = md.digest(bytes);
        String hashedUser = new String(hashedBytes);

        return hashedUser.equals(session) && secureSessions.contains(hashedUser);
    }
}