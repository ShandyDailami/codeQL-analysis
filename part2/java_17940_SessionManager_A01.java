public class java_17940_SessionManager_A01 {
    private static int sessionCount = 0;
    private static final int MAX_SESSIONS = 10;

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            new Session(i);
        }
    }

    private static class Session {
        private int id;

        Session(int id) {
            this.id = id;
            if (sessionCount < MAX_SESSIONS) {
                openSession();
            } else {
                System.out.println("Maximum session limit reached. Closing old session.");
                closeSession();
            }
        }

        private void openSession() {
            System.out.println("Opened session with id: " + id);
            sessionCount++;
        }

        private void closeSession() {
            sessionCount--;
            System.out.println("Closed session with id: " + id);
        }
    }
}