import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_37370_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session created: " + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session destroyed: " + httpSessionEvent.getSession().getId());
    }

    public static void main(String[] args) {
        // Create a new instance of SessionManager
        SessionManager sessionManager = new SessionManager();

        // Register the session listener
        javax.servlet.http.HttpServlet servlet = new javax.servlet.http.HttpServlet() {
            @Override
            protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException {
                System.out.println("Handled request: " + req.getRequestURI());

                // Create a new session
                HttpSessionEvent newSession = new HttpSessionEvent(req.getSession());
                sessionManager.sessionCreated(newSession);

                super.doGet(req, resp);
            }
        };
        servlet.init();
        servlet.service(new javax.servlet.http.HttpServletRequestWrapper(""), new javax.servlet.http.HttpServletResponseWrapper(""));
    }
}