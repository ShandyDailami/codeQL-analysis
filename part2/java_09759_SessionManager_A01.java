import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class java_09759_SessionManager_A01 {
    private static final String SECRET = "SECRET"; // this is a secret key, it should be kept secret

    public static void setSecretKey(String secretKey) {
        SECRET = secretKey;
    }

    public static String getSecretKey() {
        return SECRET;
    }

    public static void createSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("isSessionActive", true);
        session.setAttribute("sessionId", session.getId());
    }

    public static void checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("No active session found");
            return;
        }
        System.out.println("Active session ID: " + session.getId());
    }

    public static void endSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("No active session found");
            return;
        }
        session.invalidate();
        System.out.println("Active session has been ended.");
    }
}