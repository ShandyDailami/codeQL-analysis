import java.util.HashMap;

public class java_04839_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_04839_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void login(String username, String password) {
        // Placeholder for actual authentication process
        // This is a mock authentication process
        if (username.equals("admin") && password.equals("password")) {
            sessionMap.put("admin", "loggedIn");
            System.out.println("Logged in successfully as admin");
        } else {
            System.out.println("Failed to log in");
       
            throw new AuthFailureException();
        }
    }

    public void logout(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
            System.out.println("Logged out successfully");
        } else {
            System.out.println("Failed to log out. No active session found");
        }
    }

    public String getSession(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            System.out.println("Failed to get session. No active session found");
            throw new AuthFailureException();
        }
    }
}