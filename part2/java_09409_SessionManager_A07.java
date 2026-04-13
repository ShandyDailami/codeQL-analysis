import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_09409_SessionManager_A07 implements HttpSessionListener {

    private static final String[] RESERVED_WORDS = { "select", "where", "delete", "drop", "insert", "update", "declare", "select", "drop", "update" };

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String username = session.getAttribute("username").toString();

        if (isReservedWord(username)) {
            session.invalidate();
            System.out.println("Session for user " + username + " has been invalidated, as it is a reserved word.");
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // No actions required in this example
    }

    private boolean isReservedWord(String input) {
        for (String word : RESERVED_WORDS) {
            if (input.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}