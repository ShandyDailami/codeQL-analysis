public class java_09585_SessionManager_A07 {
    private User user;

    public java_09585_SessionManager_A07(User user) {
        this.user = user;
    }

    public boolean isAuthenticated() {
        // Simulate authentication by checking if user is not null
        return user != null;
    }

    public boolean isAuthorized(String action) {
        // Simulate authorization by checking if user is authorized to perform the given action
        // In a real application, you would likely want to check the user's role and permissions against a database
        // This is a simplistic example and will not work in a real-world scenario
        return user != null && user.getRole().getPermissions().contains(action);
    }

    public void startSession() {
        if (isAuthenticated()) {
            System.out.println("Session started for user: " + user.getName());
        } else {
            System.out.println("User not authenticated. Cannot start session.");
        }
    }

    public void endSession() {
        if (user != null) {
            System.out.println("Session ended for user: " + user.getName());
            user = null;
        } else {
            System.out.println("No user to end session.");
        }
    }
}

public class User {
    private String name;
    private Role role;

    public java_09585_SessionManager_A07(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }
}

public class Role {
    private String name;
    private Set<String> permissions;

    public java_09585_SessionManager_A07(String name, Set<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }
}