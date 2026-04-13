import java.util.HashMap;
import java.util.Map;

public class java_19685_SessionManager_A07 {

    // In a real system, this should be stored in a database
    private Map<String, String> userCredentials;

    public java_19685_SessionManager_A07() {
        this.userCredentials = new HashMap<>();
    }

    public boolean authenticate(String username, String password) {
        // Here we are just checking if the credentials are correct
        // In a real system, you would typically have a database
        // and compare the credentials against the stored ones

        // For the sake of simplicity, we'll assume the credentials are correct
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }

        return false;
    }

    public void startSession(String username) {
        // Here we are storing the username in a session variable
        // In a real system, you would typically have a database
        // and store the username in a session

        // For the sake of simplicity, we'll assume the username is stored in a session variable
        userCredentials.put(username, username);
    }

    public String getSessionVariable(String username) {
        // Here we are just returning a session variable
        // In a real system, you would typically have a database
        // and return the session variable

        // For the sake of simplicity, we'll assume the username is returned
        return userCredentials.get(username);
    }

    public void endSession(String username) {
        // Here we are removing the username from the session variable
        // In a real system, you would typically have a database
        // and remove the username from the session

        // For the sake of simplicity, we'll assume the username is removed from the session variable
        userCredentials.remove(username);
    }
}