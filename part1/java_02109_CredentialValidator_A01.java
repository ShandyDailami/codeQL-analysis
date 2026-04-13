public class java_02109_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_02109_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class CredentialValidator {
    private User user;

    public java_02109_CredentialValidator_A01(User user) {
        this.user = user;
    }

    public boolean validate(String providedUsername, String providedPassword) {
        if (providedUsername.equals(user.getUsername()) && providedPassword.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}