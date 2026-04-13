public class java_18158_SessionManager_A08 {
    // Using an array to store sessions
    private Session[] sessions;
    private int currentIndex;

    public java_18158_SessionManager_A08(int size) {
        sessions = new Session[size];
        currentIndex = 0;
    }

    public void openSession() {
        if (currentIndex < sessions.length) {
            sessions[currentIndex] = new Session();
            System.out.println("Opened session: " + currentIndex);
            currentIndex++;
        } else {
            System.out.println("No more sessions available.");
        }
    }

    public void closeSession() {
        if (currentIndex > 0) {
            sessions[currentIndex-1].close();
            System.out.println("Closed session: " + (currentIndex - 1));
            currentIndex--;
        } else {
            System.out.println("No active sessions.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager(5);

        manager.openSession(); // opens session 0
        manager.openSession(); // opens session 1
        manager.openSession(); // opens session 2
        manager.closeSession(); // closes session 2
        manager.closeSession(); // closes session 1
    }

    private class Session {
        private boolean isOpen;

        public java_18158_SessionManager_A08() {
            isOpen = true;
        }

        public void close() {
            isOpen = false;
        }

        public boolean isOpen() {
            return isOpen;
        }
    }
}