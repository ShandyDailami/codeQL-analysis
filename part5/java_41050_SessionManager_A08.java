import java.util.HashMap;
import java.util.Map;

public class java_41050_SessionManager_A08 {

    // Create a new session map.
    private Map<String, Object> sessionMap = new HashMap<>();

    // Get a session based on the session id.
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Add a new message to the session.
    public void addMessage(String sessionId, String message) {
        Object session = sessionMap.get(sessionId);
        if (session == null) {
            session = new Message();
            sessionMap.put(sessionId, session);
        }
        Message sessionMessage = (Message) session;
        sessionMessage.setMessage(message);
    }

    // Modify the message in the session.
    public void modifyMessage(String sessionId, String newMessage) {
        Object session = sessionMap.get(sessionId);
        if (session == null) {
            System.out.println("No session found with id " + sessionId);
            return;
        }
        Message sessionMessage = (Message) session;
        sessionMessage.setMessage(newMessage);
    }

    // A sample message class.
    class Message {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a new message to a session.
        sessionManager.addMessage("session1", "Hello, world!");

        // Retrieve the message from a session.
        Message sessionMessage = (Message) sessionManager.getSession("session1");
        System.out.println(sessionMessage.getMessage());

        // Modify the message in a session.
        sessionManager.modifyMessage("session1", "Hello, world again!");
        sessionMessage = (Message) sessionManager.getSession("session1");
        System.out.println(sessionMessage.getMessage());
    }
}