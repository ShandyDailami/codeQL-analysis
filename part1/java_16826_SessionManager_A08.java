import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class java_16826_SessionManager_A08 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    public static void main(String[] args) {
        System.out.println("Starting session listener...");
        CustomSessionListener customSessionListener = new CustomSessionListener();

        // Here you should put the logic for checking session integrity

        System.out.println("End of session listener...");
    }
}