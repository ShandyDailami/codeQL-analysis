import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_37041_SessionManager_A07 implements HttpSessionListener {

    private Map<String, HttpSession> sessionMap;

    public java_37041_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        sessionMap.put(sessionId, se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        sessionMap.remove(sessionId);
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        // Start up a server that listens for HTTP sessions.
        // You might use a library like Tomcat, Jetty, etc.
        // The following example demonstrates a way to start a Tomcat server.
        // Note: You must have Apache Tomcat installed on your machine to run this example.
        org.apache.catalina.startup.Tomcat server = new org.apache.catalina.startup.Tomcat();
        server.setPort(8080);

        // Create a new instance of SessionManager and add it as an HttpSessionListener.
        SessionManager sessionManager = new SessionManager();
        server.addListener("session", sessionManager);

        // Create a new servlet and add it to the context.
        // This servlet will listen for HTTP sessions.
        org.apache.catalina.Context context = server.createContext("/example");
        context.addServlet(org.apache.catalina.servlets.DefaultServlet.class, "default");
        context.setInitParameter("listening-address", "localhost");
        context.setInitParameter("listening-port", Integer.toString(server.getPort()));

        // Start the Tomcat server and wait for it to stop.
        server.start();
        server.waitFor();
    }
}