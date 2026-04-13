import javax.security.auth.login.LoginException;
import javax.security.auth.password.PasswordChangeException;

public class java_24637_CredentialValidator_A08 {

    private UserService userService;

    public java_24637_CredentialValidator_A08(UserService userService) {
        this.userService = userService;
    }

    public User authenticate(String username, String password) throws LoginException {
        User user = userService.findUser(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new LoginException("Invalid username or password");
        }
        return user;
    }

    public void changePassword(User user, String newPassword) throws PasswordChangeException {
        if (!user.getPassword().equals(newPassword)) {
            user.setPassword(newPassword);
        } else {
            throw new PasswordChangeException("New password cannot be the same as the old password");
        }
    }
}