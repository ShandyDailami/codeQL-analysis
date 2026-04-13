import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_21733_SessionManager_A03 implements HttpSessionListener {
    
    public static int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // This code is running when a session is created
        System.out.println("Session " + se.getSession().getId() + " created");
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // This code is running when a session is destroyed
        System.out.println("Session " + se.getSession().getId() + " destroyed");
        count--;
    }

    public static int getCount() {
        return count;
    }
}