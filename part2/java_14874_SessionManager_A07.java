import javax.management.AuthenticationFailureException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class java_14874_SessionManager_A07 {
    private static final int MAX_NUMBER_OF_SESSIONS = 10;
    private int currentSessionCount = 0;
    private Session[] sessions = new Session[MAX_NUMBER_OF_SESSIONS];

    public void openSession() throws AuthenticationFailureException {
        if (currentSessionCount < MAX_NUMBER_OF_SESSIONS) {
            sessions[currentSessionCount] = new Session();
            currentSessionCount++;
        } else {
            throw new AuthenticationFailureException("Max number of sessions reached!");
        }
    }

    public void closeSession(Session session) {
        if (session != null && Arrays.asList(sessions).contains(session)) {
            sessions[Arrays.asList(sessions).indexOf(session)] = null;
            currentSessionCount--;
        }
    }

    public static class Session {
        // In a real application, this would be populated with session data
        private String data;

        // Simulating a potential error in constructing the Session object
        public java_14874_SessionManager_A07() {
            try {
                data = "Some data";
            } catch (Exception e) {
                // Handle exception here
                e.printStackTrace();
            }
        }

        // Simulating a potential error in accessing the Session object
        public String getData() {
            if (data == null) {
                throw new RuntimeException("Data not available!");
            }
            return data;
        }
    }
}