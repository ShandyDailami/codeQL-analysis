import javax.management.*;

public class java_35263_SessionManager_A08 {
    private static final String SECURITY_DOMAIN = "A08_IntegrityFailure";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static SessionManager instance;

    private java_35263_SessionManager_A08() {}

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public String authenticate(String user, String password) {
        if (user.equals(USERNAME) && password.equals(PASSWORD)) {
            try {
                MBeanServerConnection server = ManagementFactory.getServerManagementConnection();
                ObjectName name = new ObjectName("com.sun.management:type=Security");
                server.setAttribute(name, "SessionManager.authenticateUser", Boolean.TRUE);
                return "SessionAuthenticated";
            } catch (Exception e) {
                e.printStackTrace();
                return "ErrorAuthenticating";
            }
        } else {
            return "ErrorAuthenticating";
        }
    }

    public void startSession(String sessionId) {
        try {
            MBeanServerConnection server = ManagementFactory.getServerManagementConnection();
            ObjectName name = new ObjectName("com.sun.management:type=Security,name=" + sessionId);
            server.invoke(name, "SessionManager.startSession", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endSession(String sessionId) {
        try {
            MBeanServerConnection server = ManagementFactory.getServerManagementConnection();
            ObjectName name = new ObjectName("com.sun.management:type=Security,name=" + sessionId);
            server.invoke(name, "SessionManager.endSession", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}