import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_34004_SessionManager_A01 {

    // Instance variable to store the session
    private HttpSession session;

    // Constructor
    public java_34004_SessionManager_A01(HttpSession session) {
        this.session = session;
    }

    // Method to check if the user is authenticated
    public boolean isAuthenticated() {
        return this.session.getAttribute("authenticated") != null && this.session.getAttribute("authenticated").equals("true");
    }

    // Method to authenticate a user
    public void authenticate(String username, String password) throws ServletException, IOException {
        // Here, you would typically connect to a database or another authentication service.
        // For simplicity, we'll just assume the user is authenticated if the username is "admin" and the password is "password".
        if ("admin".equals(username) && "password".equals(password)) {
            this.session.setAttribute("authenticated", "true");
            this.session.setAttribute("username", username);
        } else {
            this.session.setAttribute("authenticated", "false");
            this.session.invalidate(); // Invalidate the session to signal to the client that the session is no longer valid
            // Redirect the user to the login page
            throw new ServletException("User not authenticated", 401);
        }
    }

    // Method to logout a user
    public void logout() {
        this.session.invalidate(); // Invalidate the session to signal to the client that the session is no longer valid
        // Redirect the user to the login page
    }

    // Method to access a protected resource
    public void accessResource() throws ServletException, IOException {
        if (!this.isAuthenticated()) {
            throw new ServletException("User not authenticated", 403);
        }
        // Continue accessing the resource
    }

}