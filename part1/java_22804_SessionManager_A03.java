import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

public class java_22804_SessionManager_A03 {

    private HttpServletRequest request;

    public java_22804_SessionManager_A03(HttpServletRequest request) {
        this.request = request;
    }

    public void createSession(String sessionName) {
        HttpSession session = request.getSession(true);
        session.setAttribute("username", sessionName);
        System.out.println("Session created: " + sessionName);
    }

    public void destroySession() {
        HttpSessionContext context = request.getSessionContext();
        if (context != null) {
            Enumeration<String> names = request.getSession().getAttributeNames();
            while (names.hasMoreElements()) {
                String sessionName = names.nextElement();
                request.getSession(sessionName).invalidate();
            }
        }
    }

    public void printSessions() {
        Enumeration<String> sessionNames = request.getSession().getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            String sessionName = sessionNames.nextElement();
            HttpSession session = request.getSession(sessionName);
            System.out.println("Session name: " + sessionName + ", Session ID: " + session.getId() + ", Created on: " + session.getCreationTime());
        }
    }
}