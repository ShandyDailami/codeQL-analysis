import java.util.Hashtable;

public class java_21247_SessionManager_A01 {

    private Hashtable<String, String> sessionTable;

    public java_21247_SessionManager_A01() {
        sessionTable = new Hashtable<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionTable.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionTable.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionTable.remove(sessionID);
    }
}