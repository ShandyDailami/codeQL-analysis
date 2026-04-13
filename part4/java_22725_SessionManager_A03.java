public class java_22725_SessionManager_A03 {
    private static int sessionCount = 0;

    // This is a placeholder for a session object. In a real application, this would be a more complex object.
    private Session session;

    public java_22725_SessionManager_A03() {
        sessionCount++;
        System.out.println("Created session " + sessionCount);
        session = new Session();
    }

    public void doSomething(String value) {
        System.out.println("Doing something with " + value);
        // This is a security-sensitive operation.
        // The following line is a placeholder.
        session.doSomething(value);
    }

    // This class is used as a placeholder for a Session object. In a real application, this would be a more complex object.
    private class Session {
        public void doSomething(String value) {
            System.out.println("Doing something in a session with " + value);
        }
    }
}