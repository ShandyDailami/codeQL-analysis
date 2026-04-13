public class java_10669_SessionManager_A01 {
    private String userName;
    private String[] privilegedGroups = {"Admin", "Manager", "Secretary"};

    public void login(String user, String password) {
        // Simulate login operation here.
        userName = user;
        System.out.println("User " + userName + " logged in.");
    }

    public boolean accessResource(String group) {
        // Check if user is a member of privileged groups.
        for (String groupPrivileged : privilegedGroups) {
            if (groupPrivileged.equals(group)) {
                System.out.println("User " + userName + " has access to the resource.");
                return true;
            }
        }
        System.out.println("User " + userName + " does not have access to the resource.");
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.login("Alice", "password");

        // Attempt to access the system resource.
        sessionManager.accessResource("Manager");
    }
}