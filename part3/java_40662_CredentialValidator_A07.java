public class java_40662_CredentialValidator_A07 {
    private String username;
    private String password;

    // constructor
    public java_40662_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class CredentialValidator {
    private User currentUser;

    // constructor
    public java_40662_CredentialValidator_A07() {
        // initialize with a default user
        this.currentUser = new User("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (username.equals(this.currentUser.getUsername()) && password.equals(this.currentUser.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}