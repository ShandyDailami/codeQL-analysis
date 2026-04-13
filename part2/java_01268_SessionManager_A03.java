import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementException;
import java.util.concurrent.ConcurrentHashMap;

public class java_01268_SessionManager_A03 {
    private ConcurrentHashMap<String, String> sessionMap;

    public java_01268_SessionManager_A03() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public void startSession(String sessionId) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, "Active");
            MBeanServer mbs = MBeanServerFactory.getDefaultMBeanServer();
            ObjectName name = new ObjectName("com.example.sessionManager:type=Session,name=" + sessionId);
            mbs.registerMBean(new SessionBean(sessionId), name);
        }
    }

    public void endSession(String sessionId) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException, ManagementException {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            MBeanServer mbs = MBeanServerFactory.getDefaultMBeanServer();
            ObjectName name = new ObjectName("com.example.sessionManager:type=Session,name=" + sessionId);
            mbs.unregisterMBean(name);
        }
    }

    public String getSessionStatus(String sessionId) {
        return sessionMap.getOrDefault(sessionId, "Inactive");
    }

    public class SessionBean implements java.lang.management.MBean {
        private String sessionId;

        public java_01268_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getName() {
            return sessionId;
        }

        public String getHost() {
            return sessionId;
        }

        public void setSessionId(String newSessionId) throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException {
            setSessionId(newSessionId);
        }

        public int getSessionCount() {
            return sessionMap.size();
        }

        public int getActiveSessionCount() {
            int count = 0;
            for (String sessionId : sessionMap.values()) {
                if ("Active".equals(sessionId)) {
                    count++;
                }
            }
            return count;
        }

        public int getInactiveSessionCount() {
            int count = 0;
            for (String sessionId : sessionMap.values()) {
                if ("Inactive".equals(sessionId)) {
                    count++;
                }
            }
            return count;
        }
    }
}