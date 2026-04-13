import java.util.ArrayList;
import java.util.List;

public class java_28046_SessionManager_A01 {
    private List<String> sessions;

    public java_28046_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void createSession(String username) {
        // The session creation logic will depend on the application requirements.
        // This example just adds the username to the session list.
        sessions.add(username);
    }

    public void closeSession(String username) {
        // The session close logic will also depend on the application requirements.
        // This example just removes the username from the session list.
        sessions.remove(username);
   
        // Security-sensitive operation:
        if(sessions.contains(username)){
            System.out.println("Session found for username: " + username);
        }else{
            System.out.println("No session found for username: " + username);
        }
    }
}