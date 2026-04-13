import java.util.ArrayList;
import java.util.List;

public class java_15440_SessionManager_A01 {
    private List<SecurityUser> users;

    public java_15440_SessionManager_A01() {
        users = new ArrayList<>();
        users.add(new SecurityUser("User1", "password1", "ROLE_USER"));
        users.add(new SecurityUser("User2", "password2", "ROLE_ADMIN"));
    }

    public SecurityUser authenticate(String username, String password) {
        for (SecurityUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public List<String> getRoles(SecurityUser user) {
        List<String> roles = new ArrayList<>();
        if ("User1".equals(user.getUsername())) {
            roles.add("ROLE_USER");
            roles.add("ROLE_ADMIN");
        } else if ("User2".equals(user.getUsername())) {
            roles.add("ROLE_ADMIN");
        }
        return roles;
    }
}

class SecurityUser {
    private String username;
    private String password;
    private List<String> roles;

    public java_15440_SessionManager_A01(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<>();
        this.roles.add(role);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}