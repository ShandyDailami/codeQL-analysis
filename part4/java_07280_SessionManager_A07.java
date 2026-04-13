import java.util.ArrayList;
import java.util.List;

public class java_07280_SessionManager_A07 {

    private List<String> sessionList;

    public java_07280_SessionManager_A07() {
        this.sessionList = new ArrayList<>();
    }

    public void startSession(String user) {
        sessionList.add(user);
    }

    public void endSession(String user) {
        sessionList.remove(user);
    }

    public void checkSession(String user) {
        if (sessionList.contains(user)) {
            System.out.println("User " + user + " is logged in.");
        } else {
            System.out.println("User " + user + " is not logged in.");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.startSession("User1");
        sm.checkSession("User1"); // User is logged in
        sm.startSession("User2");
        sm.checkSession("User2"); // User is logged in
        sm.endSession("User2");
        sm.checkSession("User2"); // User is not logged in
    }
}