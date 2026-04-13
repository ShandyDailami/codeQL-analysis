import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class java_38144_SessionManager_A07 {

    private List<String> authenticatedUsers;

    public java_38144_SessionManager_A07(List<String> authenticatedUsers) {
        this.authenticatedUsers = authenticatedUsers;
    }

    public void checkAuthentication(HttpServletRequest request) {
        HttpSession session = request.getSession();

        // Check if session is new
        if (session.isNew()) {
            System.out.println("Session is new, no user authenticated");
            return;
        }

        // Check if session user is in the list of authenticated users
        String user = session.getAttribute("user");
        if (!authenticatedUsers.contains(user)) {
            System.out.println("User not authenticated");
            throw new AuthFailureException("User not authenticated");
        }

        System.out.println("User authenticated");
    }
}