public class java_36580_SessionManager_A01 {

    private static int sessionCount = 0;
    private static final List<String> activeSessions = new ArrayList<>();

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sessionManager.stop();
    }

    // Class that manages session functionality
    public static class SessionManager {
        private Thread sessionThread;
        private volatile boolean running = false;

        public void start() {
            if (running) {
                return;
            }

            running = true;
            sessionThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running) {
                        if (sessionCount > 0) {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            activeSessions.remove(activeSessions.size() - 1);
                            sessionCount--;
                        }
                    }
                }
            });
            sessionThread.start();
        }

        public void stop() {
            running = false;
            sessionThread.interrupt();
        }

        public static void createSession() {
            sessionCount++;
            activeSessions.add("Session " + sessionCount);
        }
    }

    // Class that implements Broken Access Control
    public static class BrokenAccessControl {
        public void createSession() {
            SessionManager.createSession();
        }
    }

    // Main class that uses BrokenAccessControl
    public static class MainClass {
        public static void main(String[] args) {
            MainClass mainClass = new MainClass();
            BrokenAccessControl brokenAccessControl = new BrokenAccessControl();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            brokenAccessControl.createSession();
        }
    }
}