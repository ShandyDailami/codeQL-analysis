import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

public class java_33426_SessionManager_A07 {
    private final Map<String, String> sessionMap = new HashMap<>();
    private final AccessControlContext context = new AccessControlContext();

    public String createSession(String user) {
        String sessionId = sessionMap.size() + "-" + user;
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkAccess(String sessionId) {
        AccessControl accessControl = new AccessControl() {
            @GuardedBy("this.sessionId")
            String sessionId;

            @Override
            public String getName() {
                return "Session";
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                SessionAccess other = (SessionAccess) o;
                return sessionId.equals(other.sessionId);
            }

            @Override
            public int hashCode() {
                return sessionId.hashCode();
            }

            @Override
            public boolean runAs(String primary, String authentication) throws AccessDeniedException {
                if (primary.equals(sessionId)) {
                    sessionId = primary;
                    return true;
                } else {
                    throw new AccessDeniedException("Not authorized!");
                }
            }
        };

        sessionMap.keySet().forEach(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    accessControl.runAs(sessionId, "credentials");
                } catch (AccessDeniedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}