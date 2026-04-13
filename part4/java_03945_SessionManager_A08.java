import java.io.*;
import java.util.*;

public class java_03945_SessionManager_A08 implements Serializable {
    private Map<String, Object> sessionMap;

    public java_03945_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, Object sessionObj) {
        sessionMap.put(sessionId, sessionObj);
        try {
            FileOutputStream fileOut = new FileOutputStream("session-" + sessionId + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            try {
                FileInputStream fileIn = new FileInputStream("session-" + sessionId + ".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                SessionManager sessionManager = (SessionManager) in.readObject();
                in.close();
                fileIn.close();
                return sessionManager.sessionMap.get(sessionId);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
        File file = new File("session-" + sessionId + ".ser");
        if (file.delete()) {
            System.out.println("Session " + sessionId + " deleted successfully");
        } else {
            System.out.println("Failed to delete session " + sessionId);
        }
    }
}