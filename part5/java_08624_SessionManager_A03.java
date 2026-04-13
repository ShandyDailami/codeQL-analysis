import java.util.Hashtable;

public class java_08624_SessionManager_A03 {

    private Hashtable<String, String> sessions;
    private Hashtable<String, String> validUsers;

    public java_08624_SessionManager_A03() {
        sessions = new Hashtable<>();
        validUsers = new Hashtable<>();

        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public String getSession(String user, String password) {
        if (isValidUser(user, password)) {
            String sessionId = String.valueOf(sessions.size() + 1);
            sessions.put(sessionId, user);
            return sessionId;
        }
        return null;
    }

    public String getUser(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public boolean isValidUser(String user, String password) {
        return validUsers.get(user).equals(password);
    }
}