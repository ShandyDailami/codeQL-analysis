import javax.management.*;
import javax.management.remote.*;
import java.lang.reflect.*;
import java.net.*;

public class java_17160_SessionManager_A03 {

    private MBeanServerConnection server;
    private ObjectName name;

    public java_17160_SessionManager_A03(String host, int port) throws MalformedURLException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanException, ReflectiveOperationException {
        ManagementRemote mRemote = ManagementRemoting.getManagementRemote(new StringURLConnection(new java.net.URI("service:jmx:(" + host + ":" + port + ")")));
        server = mRemote.getMBeanServerConnection();
        name = new ObjectName("com.example:type=SessionManager");
        server.registerMBean(this, name);
    }

    public void stop() throws Exception {
        server.unregisterMBean(name);
    }

    public void startSession() throws Exception {
        server.invoke(name, "startSession", null, null);
    }

    public void endSession() throws Exception {
        server.invoke(name, "endSession", null, null);
    }

    public String getSessionState() throws Exception {
        String[] attributes = server.getAttribute(name, "SessionState");
        return attributes == null ? null : attributes[0];
    }

    public String getUserName() throws Exception {
        String[] attributes = server.getAttribute(name, "UserName");
        return attributes == null ? null : attributes[0];
    }
}