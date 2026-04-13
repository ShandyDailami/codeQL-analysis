import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_00540_SessionManager_A08 implements HttpSessionListener {

    private int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed: " + activeSessions);
    }

    public static class MySessionManager {

        private static MySessionManager instance;

        public static MySessionManager getInstance() {
            if (instance == null) {
                instance = new MySessionManager();
            }
            return instance;
        }

        public HttpSession getSession() {
            return instance.createSession();
        }

        private HttpSession createSession() {
            // Create and return a session object.
            // This would typically involve creating a new ServletContext
            // and a new Session object.
            return new HttpSession() {
                @Override
                public long getCreationTime() {
                    return System.currentTimeMillis();
                }

                @Override
                public void invalidate() {
                    // Invalidate the session here. This would involve
                    // logging out the user and removing all sessions.
                }
            };
        }
    }
}