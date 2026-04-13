public class java_39539_SessionManager_A01 {
    private static int counter = 0;

    public static class Session {
        private int id;

        public java_39539_SessionManager_A01(int id) {
            this.id = id;
        }

        public void closeSession() {
            System.out.println("Closing session with ID " + this.id);
        }
    }

    public static class SessionFactory {
        public Session createSession() {
            counter++;
            return new Session(counter);
        }
    }

    public static class SecurityManager {
        public boolean isSecure() {
            return true;  // Simulate secure operation
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionFactory sessionFactory = new SessionFactory();

        if (securityManager.isSecure()) {
            Session session = sessionFactory.createSession();
            session.closeSession();
        } else {
            System.out.println("Not secure, cannot close session.");
        }
    }
}