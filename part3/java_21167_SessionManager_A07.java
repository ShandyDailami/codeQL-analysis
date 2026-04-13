import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_21167_SessionManager_A07 {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    public java_21167_SessionManager_A07(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    public void startSession() {
        session.setAttribute("user", "exampleUser");
    }

    public void endSession() {
        session.invalidate();
    }

    public void secureOperation(String userName) {
        // Check if session is started
        if (session.getAttribute("user") == null) {
            // If not started, start session
            startSession();
        }

        // Check if user is authenticated
        if (!userName.equals(session.getAttribute("user"))) {
            // If not authenticated, fail the operation
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized access.");
            return;
        }

        // Continue with the operation as authenticated user
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Operation successful!");
    }
}