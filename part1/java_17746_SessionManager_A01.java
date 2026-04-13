public class java_17746_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    // Private constructor to restrict instantiation of SessionManager
    private java_17746_SessionManager_A01() {
    }

    // Singleton pattern
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        // This is a place where you would handle the logic for starting a session
        // In a real-world example, this would likely involve connecting to a database
        session = // connect to database;
    }

    public void endSession() {
        if (session != null) {
            // This is a place where you would handle the logic for ending a session
            // In a real-world example, this would likely involve disconnecting from a database
            session.close();
        }
    }

    public void performSensitiveOperation() {
        if (session != null) {
            // This is a place where you would handle the logic for performing a sensitive operation
            // In a real-world example, this would involve interacting with a database and might involve a method like session.save()
            session.save();
        } else {
            // Handle the situation where the session has not been started
            System.out.println("Session has not been started. Please start a session before performing sensitive operations.");
        }
    }
}