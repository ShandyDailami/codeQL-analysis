import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_18969_SessionManager_A03 implements HttpSessionListener {

    private static final String SQL_INJECTION_PREVENTION = "This is a SQL injection prevention test";
    private static final String XSS_ATTACK_PREVENTION = "This is an XSS attack prevention test";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute("testAttribute", SQL_INJECTION_PREVENTION);
        session.setAttribute("anotherTestAttribute", XSS_ATTACK_PREVENTION);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // No action is required in this example
    }

    public static void main(String[] args) {
        // In a real application, you would typically instantiate this class and register it as a listener
    }
}