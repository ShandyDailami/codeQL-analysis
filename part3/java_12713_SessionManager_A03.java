import java.util.ArrayList;
import java.util.List;

public class java_12713_SessionManager_A03 {

    private List<String> sessions = new ArrayList<>();

    public void startSession() {
        System.out.println("Starting session...");
        // Simulate a long running operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sessions.add("Session started");
        System.out.println("Session started");
    }

    public void endSession() {
        System.out.println("Ending session...");
        // Simulate a long running operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String session = sessions.remove(sessions.size() - 1);
        System.out.println("Session ended: " + session);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession();
        manager.endSession();
    }
}