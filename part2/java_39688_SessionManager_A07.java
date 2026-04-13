//import necessary libraries
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_39688_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessionsCount;

    //constructor
    public java_39688_SessionManager_A07() {
        activeSessionsCount = 0;
    }

    //counts the number of active sessions
    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    //increases the session count
    public void sessionCreated(HttpSessionEvent event) {
        activeSessionsCount++;
        System.out.println("Session Created, Current Sessions: " + activeSessionsCount);
    }

    //decreases the session count
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessionsCount--;
        System.out.println("Session Destroyed, Current Sessions: " + activeSessionsCount);
   
    }

    //main method
    public static void main(String[] args) {
        //create a new instance of the SessionManager
        SessionManager sm = new SessionManager();

        //start the listener
        // Note: This is done only for demonstration purposes. In a real-world scenario, you would typically use ServletContextListener.
        // ServletContextListener contextListener = new SessionCountServletContextListener(sm);
        // ServletContext servletContext = ...;
        // servletContext.addListener(contextListener);
    }

}