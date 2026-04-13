public class java_12017_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_12017_CredentialValidator_A01(String username, String password) {
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
    private User[] users;

    public java_12017_CredentialValidator_A01() {
        this.users = new User[] {
            new User("admin", "password"),
            new User("user1", "password1"),
            new User("user2", "password2")
        };
    }

    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}