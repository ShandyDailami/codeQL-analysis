import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_17307_SessionManager_A07 implements HttpSessionListener {

    private static final long serialVersionUID = 1L;

    public java_17307_SessionManager_A07() {
        // empty on purpose
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        // Store the session id in a secure location
        session.setAttribute("secureSessionId", session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Remove the session id from a secure location
        HttpSession session = se.getSession();
        session.removeAttribute("secureSessionId");
    }

    public static void main(String[] args) {
        // start the server
        SecureSessionManager listener = new SecureSessionManager();

        // register the listener
        javax.servlet.http.HttpServlet servlet = new javax.servlet.http.HttpServlet() {
            @Override
            protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException {
                HttpSession session = request.getSession();
                // get the session id from a secure location
                String secureSessionId = (String) session.getAttribute("secureSessionId");
                // print the secure session id
                response.getWriter().println("Secure Session ID: " + secureSessionId);
            }
        };
        servlet.setServletName("SecureSessionManager");

        // register the servlet
        javax.servlet.Servlet servletContext = listener;
        servletContext.addServlet(servlet, "/secureSession/*");

        servletContext.addListener("session", listener);

        // start the servlet server
        org.apache.catalina.core.StandardContext context = new org.apache.catalina.core.StandardContext();
        context.setPath("/");
        context.addServlet(servlet, "/*");

        try {
            org.apache.catalina.startup.Tomcat.init();
            context.start();
            org.apache.catalina.startup.Tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}