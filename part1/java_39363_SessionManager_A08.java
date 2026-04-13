import javax.servlet.http.HttpSession;

public class java_39363_SessionManager_A08 {

    public static void main(String[] args) {
        // Create a new session
        HttpSession session = new HttpSession();

        // Set a session attribute
        session.setAttribute("userName", "John Doe");

        // Get a session attribute
        String userName = (String) session.getAttribute("userName");
        System.out.println("User name: " + userName);

        // Invalidate the session
        session.invalidate();

        // Check if the session is invalidated
        if (session.isInvalid()) {
            System.out.println("Session is invalidated.");
        } else {
            System.out.println("Session is valid.");
        }
    }
}