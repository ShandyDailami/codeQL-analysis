import javax.servlet.http.*;
import java.io.IOException;

public class java_16548_SessionManager_A07 implements HttpServlet {

    private static final String FAILURE_URL = "login.html";
    private static final String SUCCESS_URL = "secure.html";

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Simulating authentication process.
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            HttpSession session = req.getSession();
            session.setAttribute("authenticated", true);
            resp.sendRedirect(SUCCESS_URL);
        } else {
            resp.sendRedirect(FAILURE_URL);
        }
    }

    private boolean authenticate(String username, String password) {
        // Replace this with a real authentication process.
        // For simplicity, let's assume it's always authenticated.
        return username != null && password != null;
    }
}