import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class java_35076_SessionManager_A08 {
    private static final Logger logger = Logger.getLogger(SessionManager.class.getName());
    private List<Event> events = new ArrayList<>();

    public void addIntegrityFailureEvent(String message) {
        logger.info("Adding integrity failure event: " + message);
        events.add(new Event(message));
    }

    public void checkIntegrityFailures() {
        logger.info("Checking integrity failures...");
        for (Event event : events) {
            logger.info("Checking event: " + event.getMessage());
            // Here, we can simulate a security breach by throwing an exception
            if (event.getMessage().contains("sensitive information")) {
                throw new SecurityException("Integrity failure detected: " + event.getMessage());
            }
        }
        logger.info("No integrity failures detected.");
    }

    // Event class for simplicity
    public class Event {
        private String message;

        public java_35076_SessionManager_A08(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}