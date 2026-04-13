public class java_36405_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_36405_CredentialValidator_A07(String username, String password) {
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

    public void authenticate(String username, String password) {
        // This is a placeholder. In a real application, you'd need to fetch the user from a database or similar
        currentUser = new User(username, password);
    }

    public boolean validate() {
        // This is a placeholder. In a real application, you'd check the user's password against a hashed value or similar
        if (currentUser.getUsername().equals("admin") && currentUser.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}