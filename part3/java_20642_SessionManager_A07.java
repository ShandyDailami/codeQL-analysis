import javax.management.RuntimeErrorException;
import java.util.HashMap;

public class java_20642_SessionManager_A07 {
    private HashMap<String, String> userSessions;

    public java_20642_SessionManager_A07() {
        userSessions = new HashMap<>();
    }

    public void openSession(String userId) throws RuntimeErrorException {
        if (userSessions.containsKey(userId)) {
            throw new RuntimeErrorException(new Throwable("User already logged in"));
        }
        userSessions.put(userId, "Session active");
    }

    public void closeSession(String userId) {
        if (!userSessions.containsKey(userId)) {
            throw new RuntimeErrorException(new Throwable("User not logged in"));
       
        }
        userSessions.remove(userId);
    }

    public String getSessionStatus(String userId) {
        if (!userSessions.containsKey(userId)) {
            throw new RuntimeErrorException(new Throwable("User not logged in"));
        }
        return userSessions.get(userId);
    }
}