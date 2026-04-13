import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35827_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // This method is called when a session is created
        System.out.println("Session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // This method is called when a session is destroyed
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    public static void main(String[] args) {
        // Here is where we set the session listener
        MySessionListener sessionListener = new MySessionListener();
        // Set the session listener for all sessions
        javax.servlet.http.HttpServlet servlet = new javax.servlet.http.HttpServlet(){
            @Override
            protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException {
                super.doPost(request, response);
                setSessionListener(sessionListener);
            }
        };
        servlet.setSessionListener(sessionListener);
    }
}