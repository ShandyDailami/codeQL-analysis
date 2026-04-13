import javax.servlet.http.*;
import javax.servlet.*;

public class java_01995_SessionManager_A07 implements HttpSessionListener, HttpSessionAttributeListener {

    // list to keep track of all sessions
    private static List<HttpSession> sessionList = new ArrayList<>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionList.add(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionList.remove(se.getSession());
    }

    @Override
    public void attributeAdded(HttpSessionAttributeEvent sae) {
        HttpSession session = sae.getSession();
        String attributeName = sae.getAttributeName();
        Object attributeValue = sae.getAttributeValue();
        
        // print attribute added event
        System.out.println("Attribute " + attributeName + " added to session " + session.getId());
    }

    @Override
    public void attributeRemoved(HttpSessionAttributeEvent sre) {
        HttpSession session = sre.getSession();
        String attributeName = sre.getAttributeName();
        
        // print attribute removed event
        System.out.println("Attribute " + attributeName + " removed from session " + session.getId());
    }

    @Override
    public void attributeReplaced(HttpSessionAttributeEvent sre) {
        HttpSession session = sre.getSession();
        String attributeName = sre.getAttributeName();
        Object attributeValue = sre.getAttributeValue();
        
        // print attribute replaced event
        System.out.println("Attribute " + attributeName + " replaced in session " + session.getId());
    }

    public static void main(String[] args) {
        // Create a new SessionManager
        SessionManager sm = new SessionManager();

        // Listen for session events
        ServletContextListener scListener = new SessionContextListener();
        ServletContext servletContext = new ServletRegistration.Dynamic("sessionManagerExample", sm) {
            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                // do nothing
            }

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                // do nothing
            }
        };
        servletContext.addListener(scListener);
    }

    // Custom session context listener
    class SessionContextListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("SessionContextListener initialized");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("SessionContextListener destroyed");
        }
    }
}