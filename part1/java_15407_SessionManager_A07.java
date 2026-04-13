import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class java_15407_SessionManager_A07 {

    // In a real application, you would use a more sophisticated strategy for managing sessions.
    // This example just creates a new session and assigns it a value.

    public void createSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("uniqueSessionAttribute", "Session created successfully!");
    }

    public void retrieveSessionAttribute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionAttribute = (String) session.getAttribute("uniqueSessionAttribute");
        System.out.println("Session attribute: " + sessionAttribute);
    }

    public void deleteSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate(); // Deletes the session and destroys all data associated with it.
        System.out.println("Session has been deleted.");
    }
}