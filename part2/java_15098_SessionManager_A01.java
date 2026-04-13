import java.util.ArrayList;
import java.util.List;

public class java_15098_SessionManager_A01 {
    private List<String> sessions = new ArrayList<>();

    public void startSession() {
        sessions.add(Thread.currentThread().getName());
        System.out.println("Started session: " + Thread.currentThread().getName());
    }

    public void endSession() {
        sessions.remove(Thread.currentThread().getName());
        if (sessions.isEmpty()) {
            System.out.println("Ended session: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession();

        // Simulate a long running task
        for (int i = 0; i < 10; i++) {
            manager.startSession();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            manager.endSession();
        }
    }
}