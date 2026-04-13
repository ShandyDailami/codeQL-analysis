import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

public class java_34332_SessionManager_A08 {
    private Map<String, String> sessionMap = new HashMap<>();
    private String sessionID = null;

    public String createSession(String user) {
        sessionID = ManagementFactory.getThreadMXBean().getThreadName(ManagementFactory.getThreadMXBean().getCurrentThreadId()) + System.currentTimeMillis();
        sessionMap.put(sessionID, user);
        return sessionID;
    }

    public String getUser(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public boolean isValidSession(String sessionID) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long id = threadMXBean.getThreadId(ManagementFactory.getRuntimeMXBean().getName());
        return sessionMap.containsKey(sessionID) && sessionID.equals(threadMXBean.getThreadName(id));
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionID = sm.createSession("John");
        System.out.println("Session ID: " + sessionID);
        String user = sm.getUser(sessionID);
        System.out.println("User: " + user);
        sm.deleteSession(sessionID);
    }
}