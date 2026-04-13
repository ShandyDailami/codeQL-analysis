import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_06644_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        // Nothing to do initially
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // Check if session is valid
        if (httpSessionEvent.getSession().getAttribute("user") != null) {
            // Continue with operations related to user
            System.out.println("User logged in successfully. Continue with operations...");
        } else {
            // Handle auth failure
            try {
                throw new Exception("Authentication failed. Please log in again.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
           
            }
        }
    }
}