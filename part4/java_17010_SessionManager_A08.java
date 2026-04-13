import java.util.*;

public class java_17010_SessionManager_A08 {
    // Create a list for storing sessions
    private List<String> sessionList;

    // Constructor
    public java_17010_SessionManager_A08() {
        sessionList = new ArrayList<>();
    }

    // Method to add a session
    public void addSession(String session) {
        sessionList.add(session);
    }

    // Method to remove a session
    public boolean removeSession(String session) {
        return sessionList.remove(session);
    }

    // Method to check if a session exists
    public boolean checkSession(String session) {
        return sessionList.contains(session);
    }

    // Method to display all sessions
    public void displaySessions() {
        for(String session : sessionList) {
            System.out.println(session);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a session manager
        SessionManager sm = new SessionManager();

        // Add sessions
        sm.addSession("Session1");
        sm.addSession("Session2");
        sm.addSession("Session3");

        // Display all sessions
        sm.displaySessions();

        // Remove a session
        sm.removeSession("Session2");

        // Display all sessions after removing Session2
        sm.displaySessions();

        // Check if a session exists
        System.out.println(sm.checkSession("Session3")); // true
        System.out.println(sm.checkSession("Session4")); // false
    }
}