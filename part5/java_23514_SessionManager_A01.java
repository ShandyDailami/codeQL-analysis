import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_23514_SessionManager_A01 implements SessionListener {

    @Override
    public void sessionCreated(SessionEvent se) {
        // Nothing to do
    }

    @Override
    public void sessionDestroyed(SessionEvent se) {
        HttpSession session = se.getSession();
        HttpServletResponse response = session.getResponse();

        // Disable cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setMaxAge(0);
            }
        }

        // Clear the response to disable cookies
        response.setContent("");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}