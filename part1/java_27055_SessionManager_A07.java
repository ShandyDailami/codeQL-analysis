import java.util.ArrayList;

public class java_27055_SessionManager_A07 {

    private ArrayList<String> loggedInUsers;
    private ArrayList<String> permittedActions;

    public java_27055_SessionManager_A07() {
        loggedInUsers = new ArrayList<>();
        permittedActions = new ArrayList<>();
    }

    public void logIn(String username) {
        if (loggedInUsers.contains(username)) {
            System.out.println("User " + username + " already logged in");
        } else {
            loggedInUsers.add(username);
            System.out.println("User " + username + " has logged in");
        }
    }

    public void logOut(String username) {
        if (loggedInUsers.contains(username)) {
            loggedInUsers.remove(username);
            System.out.println("User " + username + " has logged out");
        } else {
            System.out.println("User " + username + " is not logged in");
        }
    }

    public void performAction(String username, String action) {
        if (loggedInUsers.contains(username) && permittedActions.contains(action)) {
            System.out.println("User " + username + " is performing action: " + action);
        } else {
            System.out.println("User " + username + " does not have permission to perform action: " + action);
        }
    }
}