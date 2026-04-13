import java.util.Optional;
import java.util.function.Supplier;

import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.UnknowObjectInstanceException;

public class java_29156_SessionManager_A01 {
    private MBeanServer server;
    private String objectName;

    public java_29156_SessionManager_A01(MBeanServer server, String objectName) {
        this.server = server;
        this.objectName = objectName;
    }

    public Optional<Session> createSession() {
        try {
            server.createInstance(objectName, new Object[] {});
            return Optional.of(new Session(server, objectName));
        } catch (InstanceAlreadyExistsException | MBeanException | MalformedObjectNameException | UnknowObjectInstanceException | InstanceNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void destroySession(Session session) {
        try {
            server.deleteInstance((ObjectName) session.getName(), null);
        } catch (InstanceNotFoundException | MBeanException | MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.example:type=Session");
            SessionManager sm = new SessionManager(mbs, name);
            Optional<Session> session = sm.createSession();
            session.ifPresent(s -> {
                try {
                    Thread.sleep(10000);
                    sm.destroySession(s);
                } catch (InterruptedException | MBeanException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}