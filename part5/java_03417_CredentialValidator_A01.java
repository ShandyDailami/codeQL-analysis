public class java_03417_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_03417_CredentialValidator_A01(String username, String password) {
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

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public boolean validateCredentials(String username, String password) {
        if (currentUser == null) {
            throw new RuntimeException("No current user");
        }

        return currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password);
    }
}