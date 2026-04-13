public class java_40406_SessionManager_A01 implements SessionManager {
    // Session object
    private Session session;

    public java_40406_SessionManager_A01() {
        // Create a new session
        session = new CustomSession();
    }

    @Override
    public void startSession() {
        // Check for broken access control
        if (session.isBroken()) {
            System.out.println("Broken access control detected, session not started!");
        } else {
            session.start();
            System.out.println("Session started successfully!");
        }
    }

    @Override
    public void stopSession() {
        // Check for broken access control
        if (session.isBroken()) {
            System.out.println("Broken access control detected, session not stopped!");
        } else {
            session.stop();
            System.out.println("Session stopped successfully!");
        }
    }

    @Override
    public void closeSession() {
        // Check for broken access control
        if (session.isBroken()) {
            System.out.println("Broken access control detected, session not closed!");
        } else {
            session.close();
            System.out.println("Session closed successfully!");
        }
    }
}

// CustomSession class, implementing Session interface
class CustomSession implements Session {
    private boolean broken;

    @Override
    public void start() {
        // Simulate start operation
        broken = false;
        System.out.println("Session started!");
    }

    @Override
    public void stop() {
        // Simulate stop operation
        broken = false;
        System.out.println("Session stopped!");
    }

    @Override
    public void close() {
        // Simulate close operation
        broken = false;
        System.out.println("Session closed!");
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}

// SessionManager interface
interface SessionManager {
    void startSession();
    void stopSession();
    void closeSession();
}

// Session interface
interface Session {
    void start();
    void stop();
    void close();
    boolean isBroken();
}