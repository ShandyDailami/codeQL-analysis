import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_00404_SessionManager_A07 implements HttpSessionListener {

    private int sessionCount;

    public java_00404_SessionManager_A07() {
        sessionCount = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created: " + se.getSession().getId());
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed: " + se.getSession().getId());
        sessionCount--;
    }

    public int getSessionCount() {
        return sessionCount;
    }

}