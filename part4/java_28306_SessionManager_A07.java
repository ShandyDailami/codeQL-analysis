import javax.servlet.http.*;

public class java_28306_SessionManager_A07 {

    public static void main(String[] args) {
        // Create a new session
        HttpSession session = new HttpSession();

        // Set a session attribute
        session.setAttribute("username", "John Doe");

        // Get the session ID
        String sessionID = session.getId();
        System.out.println("Session ID: " + sessionID);

        // Get the session attribute
        String username = (String) session.getAttribute("username");
        System.out.println("Username: " + username);

        // Expire the session
        session.invalidate();
    }
}