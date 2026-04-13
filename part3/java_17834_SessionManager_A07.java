import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class java_17834_SessionManager_A07 {
    private static final String SESSION_ID = "session_id";

    public static void startSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_ID, session.getId());
    }

    public static void endSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute(SESSION_ID);
        session.invalidate(); // end the session

        // send a response back to the client
        response.setContentType("text/plain");
        response.getWriter().println("Session " + sessionId + " ended.");
    }
}