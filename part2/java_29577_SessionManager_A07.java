public class java_29577_SessionManager_A07 {
    private String name;

    public java_29577_SessionManager_A07(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class AuthFailure extends Exception {
    public java_29577_SessionManager_A07(String message) {
        super(message);
    }
}

public class SessionManager {
    private User user;

    public java_29577_SessionManager_A07(User user) {
        this.user = user;
    }

    public void accessResource(String resource) throws AuthFailure {
        if ("private".equals(resource)) {
            throw new AuthFailure("Access denied for user: " + user.getName());
        } else {
            System.out.println("Access granted for user: " + user.getName());
        }
    }
}