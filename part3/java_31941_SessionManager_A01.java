public class java_31941_SessionManager_A01 {
    private User currentUser;

    public java_31941_SessionManager_A01() {
        // initialize with default user
        this.currentUser = new User("default", "password", Role.ADMIN);
    }

    public void setUser(User user) {
        this.currentUser = user;
    }

    public boolean hasAccess(String resource) {
        switch(resource) {
            case "document":
                return currentUser.getRole() == Role.ADMIN || currentUser.getRole() == Role.USER;
            case "settings":
                return currentUser.getRole() == Role.ADMIN;
            default:
                return false;
        }
    }
}

public class User {
    private String username;
    private String password;
    private Role role;

    public java_31941_SessionManager_A01(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}

public class Role {
    public static final int USER = 1;
    public static final int ADMIN = 2;
}