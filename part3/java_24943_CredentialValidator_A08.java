public class java_24943_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_24943_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class PasswordManager {
    private List<User> users = new ArrayList<>();

    public java_24943_CredentialValidator_A08() {
        // Add some users for testing
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
    }

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }

    public boolean isPasswordPresent(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}