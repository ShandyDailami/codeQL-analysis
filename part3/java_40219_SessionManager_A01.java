import javax.management.*;
import javax.management.remote.*;
import javax.naming.*;

public class java_40219_SessionManager_A01 {

    public static void main(String[] args) {

        try {
            // Step 1: Create a context
            InitialContext context = new InitialContext();

            // Step 2: Look up the JMX service
            MBeanServerConnection mbs = (MBeanServerConnection) context.lookup("java:comp/jmx/remote");

            // Step 3: Create and register a new MBean
            ObjectName name = new ObjectName("com.example.SessionManager:type=Session");
            mbs.registerMBean(new Session(), name, null);

            // Step 4: Print the MBean information
            System.out.println("Registered MBean: " + name.getKey());

            // Step 5: Wait for user input
            System.out.println("Press enter to stop...");
            System.in.read();

            // Step 6: Unregister the MBean
            mbs.unregisterMBean(name);

            // Step 7: Clean up
            context.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Session implements SessionMBean {

        private boolean isActive = true;

        @Override
        public void setActive(boolean active) throws NotCompliantMBeanException, MBeanException {
            System.out.println("Setting active to " + active);
            isActive = active;
        }

        @Override
        public boolean isActive() {
            return isActive;
        }

        @Override
        public void closeSession() throws NotCompliantMBeanException, MBeanException {
            isActive = false;
            System.out.println("Session closed");
        }
    }
}