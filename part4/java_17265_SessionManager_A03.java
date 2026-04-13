import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_17265_SessionManager_A03 {

    public static void main(String[] args) {
        // Create a session
        HttpSession session = createSession();

        // Store a value in the session
        storeValueInSession(session);

        // Retrieve the value from the session
        retrieveValueFromSession(session);

        // Destroy the session
        destroySession(session);
    }

    private static HttpSession createSession() {
        // Create a new session, if one doesn't exist yet
        return getRequest().getSession();
    }

    private static void storeValueInSession(HttpSession session) {
        // Store a value in the session
        session.setAttribute("uniqueValue", "This is a unique value");
    }

    private static void retrieveValueFromSession(HttpSession session) {
        // Retrieve the value from the session
        String value = (String) session.getAttribute("uniqueValue");
        System.out.println("Retrieved value: " + value);
    }

    private static void destroySession(HttpSession session) {
        // Destroy the session
        session.invalidate();
    }

    private static HttpServletRequest getRequest() {
        // Get the current request
        return (HttpServletRequest) javax.servlet.http.HttpServletRequest.class;
    }
}