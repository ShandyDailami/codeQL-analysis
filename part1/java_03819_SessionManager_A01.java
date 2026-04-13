public class java_03819_SessionManager_A01 {

    private static Session currentSession;

    public static Session getSession() {
        if (currentSession == null) {
            currentSession = new Session();
            currentSession.init();
        }
        return currentSession;
    }

    public static void destroySession() {
        if (currentSession != null) {
            currentSession.dispose();
            currentSession = null;
        }
    }

    private static class Session {
        private boolean isActive;

        public void init() {
            System.out.println("Session Started");
            isActive = true;
        }

        public void dispose() {
            System.out.println("Session Ended");
            isActive = false;
        }

        public boolean isActive() {
            return isActive;
        }
    }
}