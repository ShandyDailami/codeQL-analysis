import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementException;
import java.net.MalformedURLException;

public class java_14476_SessionManager_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a JMX MBean server
            MBeanServer mbs = MBeanServerFactory.createMBeanServer();

            // Step 2: Create a new instance of our session manager
            SessionManagerBean sm = new SessionManagerBean();

            // Step 3: Register our session manager with the JMX MBean server
            ObjectName name = new ObjectName("com.example.SessionManagerBean");
            mbs.registerMBean(sm, name);

            // Step 4: Wait for the session manager to be operational
            while (true) {
                Thread.sleep(1000);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (ManagementException e) {
            e.printStackTrace();
        }
    }

    // Step 5: Define our session manager as a MBean
    static class SessionManagerBean implements SessionManagerMBean {

        private boolean sessionActive = false;

        @Override
        public void startSession() {
            sessionActive = true;
        }

        @Override
        public void endSession() {
            sessionActive = false;
        }

        @Override
        public boolean isSessionActive() {
            return sessionActive;
        }

    }

    // Step 6: Define a MBean interface
    interface SessionManagerMBean {

        void startSession();

        void endSession();

        boolean isSessionActive();

    }

}