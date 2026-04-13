import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

public class java_33570_SessionManager_A07 {

    public static void main(String[] args) {
        // Create a new HttpServletRequest object
        HttpServletRequest request = new HttpServletRequest();

        // Create a new session for the request
        HttpSession session = request.getSession();

        // Store a data in the session
        session.setAttribute("userId", "A07_AuthFailure");

        // Retrieve the data from the session
        String userId = (String) session.getAttribute("userId");
        System.out.println("User ID: " + userId);
    }
}