import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_09892_SessionManager_A03 implements Servlet {

    // This is a simple in-memory store for sessions
    private static class SessionData {
        private String id;
        private String value;

        public java_09892_SessionManager_A03(String id, String value) {
            this.id = id;
            this.value = value;
        }

        public String getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private static final long serialVersionUID = 1L;

    private SessionData sessionData;

    public java_09892_SessionManager_A03() {
        sessionData = new SessionData("default", "Default Session Value");
    }

    public void service(HttpRequest request, HttpResponse response) throws ServletException, IOException {
        // This is a dummy implementation of a session service
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Session ID: " + sessionData.getId());
        out.println("Session Value: " + sessionData.getValue());
    }

    public void init(ServletConfig config) throws ServletException {
        // Initialize the session data here if necessary
    }

    public void destroy() {
        // Cleanup the session data here if necessary
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void setServletConfig(ServletConfig servletConfig) {
        // Not used in this implementation
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }
}