public class java_11880_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_11880_CredentialValidator_A03(String username, String password) {
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

    public java_11880_CredentialValidator_A03(User user) {
        this.user = user;
    }

    public boolean validateCredentials(String username, String password) {
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}