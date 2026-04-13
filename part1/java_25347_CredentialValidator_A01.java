public class java_25347_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_25347_CredentialValidator_A01(String username, String password) {
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

    public java_25347_CredentialValidator_A01() {
        // Hardcoded user for authentication.
        currentUser = new User("admin", "password");
    }

    public boolean authenticate(String username, String password) {
        if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}