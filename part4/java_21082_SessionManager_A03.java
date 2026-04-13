import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_21082_SessionManager_A03 implements HttpSessionListener {

    private static final long SECONDS_IDLE = 60;
    private static final long MAX_SESSIONS = 10;

    private static long idleCount = 0;
    private static long startTime = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        session.setMaxInactiveInterval((int) SECONDS_IDLE);
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        idleCount++;
        if (idleCount > MAX_SESSIONS) {
            if (System.currentTimeMillis() - startTime > SECONDS_IDLE * 1000) {
                System.out.println("Session " + session.getId() + " was idle for more than " + SECONDS_IDLE + " seconds. Expiring session.");
                session.invalidate();
            } else {
                System.out.println("Session " + session.getId() + " was idle for " + idleCount + " times, but not for more than " + SECONDS_IDLE + " seconds. Continue to use it.");
            }
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        if (idleCount > 0) {
            idleCount--;
        }
        if (System.currentTimeMillis() - startTime > SECONDS_IDLE * 1000 && idleCount == 0) {
            System.out.println("Session " + session.getId() + " was not used for " + SECONDS_IDLE + " seconds. Expiring session.");
        }
    }
}