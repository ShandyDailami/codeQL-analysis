import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.sql.DataSource;
import java.sql.SQLException;

public class java_23151_SessionManager_A01 {
    private DataSource dataSource;
    private MBeanServer mBeanServer;

    public java_23151_SessionManager_A01(DataSource dataSource) {
        this.dataSource = dataSource;
        try {
            mBeanServer = MBeanServerFactory.createMBeanServer();
        } catch (MalformedObjectNameException | NotCompliantMBeanException | InstanceAlreadyExistsException | MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

    public void startSession() {
        try {
            ObjectName name = new ObjectName("com.example.SessionManager:type=Session");
            mBeanServer.registerMBean(new Session(), name, null);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | InstanceAlreadyExistsException | MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

    public void stopSession() {
        try {
            ObjectName name = new ObjectName("com.example.SessionManager:type=Session");
            mBeanServer.unregisterMBean(name);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | SQLException e) {
            e.printStackTrace();
        }
    }

    private class Session implements SessionInterface {
        public void openSession() {
            try (Connection connection = dataSource.getConnection()) {
                // open session here
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void closeSession() {
            // close session here
        }

        public void executeQuery(String query) {
            // execute query here
        }
    }
}