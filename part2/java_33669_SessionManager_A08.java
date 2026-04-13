import javax.management.*;
import javax.management.remote.*;

public class java_33669_SessionManager_A08 {

    private static final String SERVER_URL = "targetServer";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    private static SessionManager sessionManager;

    static {
        try {
            // Create the initial MBeanServer
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

            // Create a new SessionFactory
            MBeanInfo mbInfo = new SimpleObjectMBeanInfo(
                    new String[] {"UniqueVanillaJavaSessionManager"},  // interfaces
                    new Object[] {String.class, String.class},  // methods
                    new Object[] {String.class});  // constructor

            // Register the new object
            mbs.registerMBean(new UniqueVanillaJavaSessionManagerImpl("localhost", "root", "password"), mbInfo);

            // Create the initial SessionManager
            sessionManager = new StandardSessionManager(new String[] {
                    "user=root;password=password;host=localhost",
                    "user=root;password=password;host=localhost"
            });

        } catch (MalformedObjectNameException | NotCompliantMBeanException | InstanceAlreadyExistsException | MBeanRegistrationException | ReflectionException | UnavailableMBeanException e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return sessionManager.getSession();
    }

    public static void main(String[] args) throws Exception {
        Session session = getSession();

        // Start integrity failure
        session.beginIntegrityFailure();

        // End the session
        session.endIntegrityFailure();

        // Close the session
        session.close();
    }

    private static class UniqueVanillaJavaSessionManagerImpl implements SessionManager {
        private String[] hosts;
        private String username;
        private String password;

        public java_33669_SessionManager_A08(String host, String user, String pass) {
            this.hosts = new String[]{host};
            this.username = user;
            this.password = pass;
        }

        @Override
        public Session getSession() {
            return new UniqueVanillaJavaSession(hosts, username, password);
        }
    }

    private static class UniqueVanillaJavaSession implements Session {
        private String[] hosts;
        private String username;
        private String password;

        public java_33669_SessionManager_A08(String[] hosts, String username, String password) {
            this.hosts = hosts;
            this.username = username;
            this.password = password;
        }

        @Override
        public void beginIntegrityFailure() {
            // Do nothing
        }

        @Override
        public void endIntegrityFailure() {
            // Do nothing
        }

        @Override
        public void close() {
            // Do nothing
        }
    }

    private static class StandardSessionManager implements SessionManager {
        private String[] urls;

        public java_33669_SessionManager_A08(String[] urls) {
            this.urls = urls;
        }

        @Override
        public Session getSession() {
            // TODO: implement this method
            return null;
        }
    }
}