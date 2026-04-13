import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.SessionContext;
import java.io.IOException;

@WebServlet(urlPatterns = "/session-demo")
public class java_08392_SessionManager_A03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get session context
        SessionContext ctx = req.getSessionContext();

        // Start a new session
        if (ctx.getSession(true) == null) {
            System.out.println("Started a new session");
        } else {
            System.out.println("Using an existing session");
        }

        // Store a value in the session
        req.getSession().setAttribute("user", "John Doe");

        // Get the value from the session
        String user = (String) req.getSession().getAttribute("user");
        System.out.println("User: " + user);

        // End the session
        req.getSession().invalidate();

        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().println("Session demo done");
    }
}