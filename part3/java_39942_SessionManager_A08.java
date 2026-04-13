import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class java_39942_SessionManager_A08 {

    private Map<String, Object> sessions = new HashMap<>();

    public void createSession(String name) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
        MBeanServer server = MBeanServerFactory.getDefaultMBeanServer();
        ObjectName nameObj = new ObjectName(name);
        sessions.put(name, server.createInstance("Session: " + name, new Class[]{String.class}, new Object[]{name}));
        server.registerMBean(sessions.get(name), nameObj);
    }

    public void accessSessionData(String name) throws InvocationTargetException, IllegalAccessException, InstanceNotFoundException {
        if (sessions.containsKey(name)) {
            Method method = sessions.get(name).getClass().getDeclaredMethod("accessSessionData");
            method.invoke(sessions.get(name));
        } else {
            throw new InstanceNotFoundException("No session found with the name: " + name);
        }
    }

    public static class InstanceNotFoundException extends Exception {
        public java_39942_SessionManager_A08(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException, InvocationTargetException, IllegalAccessException, InstanceNotFoundException {
        SessionManager manager = new SessionManager();
        manager.createSession("Session1");
        manager.accessSessionData("Session1");
    }
}