import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_07617_SessionManager_A03 {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public java_07617_SessionManager_A03(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void startSession() {
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", "User1"); // replace "User1" with actual user details
        response.setHeader("Session-ID", session.getId());
    }

    public void checkSession() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            System.out.println("Session ID: " + session.getId());
        } else {
            System.out.println("No active session found");
        }
    }

    public void endSession() {
        HttpSession session = request.getSession();
        session.invalidate();
        response.setHeader("Session-ID", session.getId());
    }
}