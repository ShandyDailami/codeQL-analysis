public class java_25744_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_25744_CredentialValidator_A08(String username, String password) {
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
    private User currentUser;

    public java_25744_CredentialValidator_A08(String username, String password) {
        currentUser = new User(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}