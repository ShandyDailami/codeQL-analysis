import java.util.HashMap;
import java.util.Map;

public class java_06749_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_06749_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionID) {
        if(sessions.containsKey(sessionID)) {
            return "Error: Session Already Exists";
        } else {
            Session session = new Session(sessionID);
            sessions.put(sessionID, session);
            return "Success: Session Created";
        }
    }

    public String getSessionData(String sessionID) {
        if(sessions.containsKey(sessionID)) {
            return sessions.get(sessionID).getData();
        } else {
            return "Error: Session Does Not Exists";
        }
    }

    public String addSessionData(String sessionID, String data) {
        if(sessions.containsKey(sessionID)) {
            sessions.get(sessionID).addData(data);
            return "Success: Data Added to Session";
        } else {
            return "Error: Session Does Not Exists";
        }
    }

    public String removeSessionData(String sessionID, String data) {
        if(sessions.containsKey(sessionID)) {
            sessions.get(sessionID).removeData(data);
            return "Success: Data Removed from Session";
        } else {
            return "Error: Session Does Not Exists";
        }
    }

    public String updateSessionData(String sessionID, String oldData, String newData) {
        if(sessions.containsKey(sessionID)) {
            if(sessions.get(sessionID).getData().contains(oldData)) {
                sessions.get(sessionID).updateData(oldData, newData);
                return "Success: Data Updated in Session";
            } else {
                return "Error: Old Data Not Found in Session";
            }
        } else {
            return "Error: Session Does Not Exists";
        }
    }
}