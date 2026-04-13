import java.util.HashMap;
import java.util.Map;

public class java_09919_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_09919_SessionManager_A07() {
        // Create a basic map with hardcoded credentials.
        // In a real-world application, this should come from a secure source such as a database.
        credentials = new HashMap<String, String>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public String authenticate(String username, String password) {
        // Check if the provided username and password match a stored username and password.
        // This is a very basic example, in a real-world application, you should use a secure method for comparing passwords.
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return "Successfully authenticated!";
        } else {
            return "Authentication failed!";
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Use the session manager to authenticate a user.
        System.out.println(sessionManager.authenticate("user1", "password1"));
    }
}