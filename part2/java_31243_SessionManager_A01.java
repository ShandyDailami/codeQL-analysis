import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;

import com.sun.management.internal.MBeanServerImpl;

public class java_31243_SessionManager_A01 {
    public static void main(String[] args) {
        try {
            // Create a new MBeanServer
            MBeanServer mbs = new MBeanServerImpl();

            // Create a new StandardMBean
            StandardMBean bean = new StandardMBean(new SessionManager(), SessionManager.class);

            // Register the bean
            mbs.registerMBean(bean, new ObjectName("com.example.SessionManager"));

            // Wait for user input to terminate the program
            System.in.read();

            // Unregister the bean
            mbs.unregisterMBean(new ObjectName("com.example.SessionManager"));

        } catch (MalformedObjectNameException | MBeanRegistrationException | InstanceAlreadyExistsException | NotCompliantMBeanException | MalformedObjectNameException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class SessionManager implements Runnable {
        private volatile boolean running = true;

        public void run() {
            while (running) {
                try {
                    // Simulate a security-sensitive operation here
                    // For instance, accessing a private member
                    System.out.println("Accessing a private member...");

                    // Sleep for a while
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stop() {
            running = false;
        }
    }
}