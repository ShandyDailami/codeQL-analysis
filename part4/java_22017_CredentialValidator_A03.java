import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;

public interface CredentialValidator {
    boolean validateCredentials(String username, String password) throws AuthenticationException, LoginException;
}

public class java_22017_CredentialValidator_A03 implements CredentialValidator {

    // Simulated database access
    private UserService userService;

    public java_22017_CredentialValidator_A03(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean validateCredentials(String username, String password) throws AuthenticationException, LoginException {
        User user = userService.getUser(username);
        if (user == null) {
            throw new AuthenticationException("User not found");
        }
        if (!user.isActive()) {
            throw new AuthenticationException("User is not active");
        }
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Invalid password");
        }
        return true;
    }
}

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public java_22017_CredentialValidator_A03() {
        users.put("user1", new User("user1", "password1", true));
        users.put("user2", new User("user2", "password2", false));
    }

    public User getUser(String username) {
        return users.get(username);
    }
}

public class User {
    private String username;
    private String password;
    private boolean active;

    public java_22017_CredentialValidator_A03(String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }
}