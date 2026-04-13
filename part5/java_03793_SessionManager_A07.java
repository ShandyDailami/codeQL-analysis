import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_03793_SessionManager_A07 {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public java_03793_SessionManager_A07(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void startSession() {
        // Start a new session if one does not already exist.
        Optional.ofNullable(request.getSession(true))
                .ifPresent(session -> System.out.println("Session started: " + session.getId()));
    }

    public void storeValueInSession(String key, String value) {
        // Store a value in the session.
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
        System.out.println("Value stored in session: " + value);
    }

    public String retrieveValueFromSession(String key) {
        // Retrieve a value from the session.
        HttpSession session = request.getSession();
        return (String) session.getAttribute(key);
    }

    public void endSession() {
        // End the session.
        HttpSession session = request.getSession();
        session.invalidate();
        System.out.println("Session ended: " + session.getId());
    }
}