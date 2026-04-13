import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_40695_SessionManager_A03 implements HttpSessionListener {

    private HttpSession session;

    public java_40695_SessionManager_A03(HttpSession session) {
        this.session = session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Session created event
        System.out.println("Session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Session destroyed event
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    public static void main(String[] args) {
        // Create and start a session
        javax.servlet.http.HttpServlet servlet = new javax.servlet.http.HttpServlet() {
            @Override
            protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException {
                System.out.println("doGet method called");
            }
        };

        javax.servlet.http.HttpSession session = servlet.getSession();
        servlet.doGet(request, response);

        // Set the session manager
        SessionManager sessionManager = new SessionManager(session);
        session.setSessionListener(sessionManager);

        // Destroy the session
        session.invalidate();
    }
}