import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_17909_SessionManager_A01 {
    private static final String BROKEN_SESSION_ID = "BROKEN_SESSION_ID";

    public void startSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setId(BROKEN_SESSION_ID);
        session.setAttribute("valid", "Session is valid");
    }

    public void endSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getId().equals(BROKEN_SESSION_ID)) {
            session.invalidate();
        }
    }

    public void accessSessionAttribute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getId().equals(BROKEN_SESSION_ID)) {
            System.out.println("Accessing session attribute: " + session.getAttribute("valid"));
        }
    }
}