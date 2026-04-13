import java.util.concurrent.TimeUnit;

public class java_27004_SessionManager_A08 {
    private java.util.Timer timer;
    private boolean sessionClosed;
    private static final int CLOSE_TIME = 10; // 10 seconds

    public java_27004_SessionManager_A08() {
        sessionClosed = false;
        timer = new java.util.Timer();
        timer.schedule(new CloseTask(), CLOSE_TIME * 1000);
    }

    public void startSession() {
        // Start the session here, if necessary.
        // This is not a security sensitive operation.
    }

    public void endSession() {
        sessionClosed = true;
        timer.cancel();

        // End the session here, if necessary.
        // This is not a security sensitive operation.
    }

    private class CloseTask extends java.util.TimerTask {
        @Override
        public void run() {
            if (!sessionClosed) {
                System.out.println("Session was not closed properly. Closing now.");
                endSession();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession();
        try {
            // Your operation here.
            // This is not a security sensitive operation.
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            manager.endSession();
        }
    }
}