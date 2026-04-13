public class java_02270_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_02270_CredentialValidator_A07(String username, String password) {
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

    public java_02270_CredentialValidator_A07() {
        users = new User[] {
            new User("user1", "password1"),
            new User("user2", "password2"),
            new User("user3", "password3")
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