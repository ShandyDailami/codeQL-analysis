import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_04071_SessionManager_A07 implements HttpSessionListener {

    private int totalSessions;

    public java_04071_SessionManager_A07() {
        totalSessions = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        totalSessions++;
        System.out.println("Session Created: " + totalSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        totalSessions--;
        System.out.println("Session Destroyed: " + totalSessions);
    }

    public static void main(String[] args) {
        System.out.println("Starting SessionManager...");

        //Create a new SessionManager
        SessionManager sm = new SessionManager();

        //Create a new HttpSession
        HttpSession session = new HttpSession(sm);

        //Add the session listener
        session.addListener(sm);

        //Do some operations
        session.setAttribute("example", "Example Value");
        System.out.println("Session ID: " + session.getId());

        session.invalidate(); //Destroy the session

        System.out.println("End of SessionManager...");
    }
}