import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_18978_SessionManager_A07 {
    public void secureLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        // Implement login logic here, and if successful, create a session
        if (validateLogin(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.addHeader("Set-Cookie", "username=" + username + "; Secure; HttpOnly");
        } else {
            // If login failed, set an error message and redirect to login page
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    private boolean validateLogin(String username, String password) {
        // Implement actual login validation here
        // For now, return true if username and password are not empty
        return !(username.isEmpty() || password.isEmpty());
    }

    public void secureLogout(HttpServletRequest request, HttpServletResponse response) {
        // Implement logout logic here
        HttpSession session = request.getSession();
        session.invalidate();
        // Set a cookie to delete session
        response.addHeader("Set-Cookie", "session=destroyed; expires=Thu, 01 Jan 1970 00:00:00 GMT; Path=/; HttpOnly");
    }
}