public class java_25601_SessionManager_A08 {
    private static int sessionCount = 0;

    private java_25601_SessionManager_A08() {
        // This is a private constructor to prevent instantiation
    }

    public static Session getSession() {
        sessionCount++;

        // Here we're simply returning a Session object with a unique ID
        // This is a very basic implementation, in a real application, you would probably want to use a more complex object
        return new Session() {
            @Override
            public int getId() {
                return sessionCount;
            }
        };
    }

    public static void main(String[] args) {
        Session session1 = getSession();
        Session session2 = getSession();

        System.out.println("Session 1 ID: " + session1.getId());
        System.out.println("Session 2 ID: " + session2.getId());
    }
}